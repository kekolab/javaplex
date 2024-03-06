package kekolab.javaplex;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.BasicHttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class PlexHTTPClient {
	static final String CONTEXT_ATTRIBUTE_PEER_CERTIFICATES = "peer-certificates";
	static final String HEADER_X_PLEX_PROVIDES = "X-Plex-Provides";
	static final String HEADER_X_PLEX_DEVICE_NAME = "X-Plex-Device-Name";
	static final String HEADER_X_PLEX_DEVICE = "X-Plex-Device";
	static final String HEADER_X_PLEX_PLATFORM_VERSION = "X-Plex-Platform-Version";
	static final String HEADER_X_PLEX_PLATFORM = "X-Plex-Platform";
	static final String HEADER_X_PLEX_CLIENT_IDENTIFIER = "X-Plex-Client-Identifier";
	static final String HEADER_X_PLEX_VERSION = "X-Plex-Version";
	static final String HEADER_X_PLEX_PRODUCT = "X-Plex-Product";
	static final String PARAMETER_X_PLEX_TOKEN = "X-Plex-Token";

	private HttpClient client;
	private ObjectMapper xmlMapper, jsonMapper;

	protected PlexHTTPClient(HttpClient client) {
		this.client = client;
		xmlMapper = new XmlMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		jsonMapper = new JsonMapper().configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
	}

	private <T> T executeAndCallResponseHandler(ClassicHttpRequest request, String token,
			HttpClientResponseHandler<T> handler) {
		addTokenToRequest(request, token);
		try {
			return client.execute(request, new BasicHttpContext(), handler);
		} catch (IOException e) {
			throw new PlexException(e);
		}
	}

	<A> A executeAndCreateFromResponse(ClassicRequestBuilder builder, BaseItem body, String contentType, Class<A> cls, String token) {
		ObjectMapper mapper = contentType.toLowerCase().contains("xml") ? xmlMapper : jsonMapper;
		try {
			builder.setEntity(mapper.writeValueAsString(body));
		} catch (JsonProcessingException e) {
			throw new PlexException(e); // TODO Maybe something better
		}
		return executeAndCallResponseHandler(builder.build(), token, (response) -> parseIntoNewObject(response, cls));
	}

	<A> A executeAndCreateFromResponse(ClassicHttpRequest request, Class<A> cls, String token) {
		return executeAndCallResponseHandler(request, token, (response) -> parseIntoNewObject(response, cls));
	}

	<A> A executeAndUpdateFromResponse(ClassicHttpRequest request, A item, String token) {
		return executeAndCallResponseHandler(request, token, (response) -> parseAndUpdateObject(response, item));
	}

	Void execute(ClassicHttpRequest request, String token) {
		return executeAndCallResponseHandler(request, token, this::checkRespondeCode);
	}

	private void addTokenToRequest(ClassicHttpRequest request, String token) {
		if (token != null) {
			try {
				URIBuilder uri = new URIBuilder(request.getUri());
				uri.setParameter(PARAMETER_X_PLEX_TOKEN, token);
				request.setUri(uri.build());
			} catch (URISyntaxException e) {
				throw new PlexException(e);
			}
		}
	}

	private <A> A parseIntoNewObject(ClassicHttpResponse response, Class<A> cls) {
		HttpEntity entity = extractEntity(response);
		if (entity == null)
			throw new PlexException("Cannot parse the response: received entity is null");
		try {
			return chooseMapper(response).readValue(entity.getContent(), cls);
		} catch (UnsupportedOperationException | IOException e) {
			throw new PlexException(e);
		}
	}

	private <A> A parseAndUpdateObject(ClassicHttpResponse response, A item) {
		HttpEntity entity = extractEntity(response);
		if (entity == null)
			throw new PlexException("Cannot parse the response: received entity is null");
		try {
			return chooseMapper(response).readerForUpdating(item).readValue(entity.getContent());
		} catch (UnsupportedOperationException | IOException e) {
			throw new PlexException(e);
		}
	}

	private Void checkRespondeCode(ClassicHttpResponse response) {
		int code = response.getCode();
		if (code >= 400) {
			StringBuilder exceptionMessageBuilder = new StringBuilder().append("Error processing the server response:")
					.append(System.lineSeparator()).append(System.lineSeparator()).append("CODE : ")
					.append(response.getCode()).append(System.lineSeparator());
			for (Header header : response.getHeaders())
				exceptionMessageBuilder.append(header.getName()).append(" : ").append(header.getValue())
						.append(System.lineSeparator());
			IOException inner = null;
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				StringBuilder body = new StringBuilder();
				try (Scanner s = new Scanner(entity.getContent())) {
					while (s.hasNextLine())
						body.append(s.nextLine());
					exceptionMessageBuilder.append(System.lineSeparator()).append(body);
				} catch (IOException e) {
					exceptionMessageBuilder.append(System.lineSeparator()).append("ERROR WHILE READING RESPONSE BODY");
					inner = e;
				} finally {
					exceptionMessageBuilder.append(System.lineSeparator());
				}
			}
			String exceptionMessage = exceptionMessageBuilder.toString();
			if (inner == null)
				throw new PlexException(exceptionMessage);
			throw new PlexException(exceptionMessage, inner);
		}
		return null;
	}

	private HttpEntity extractEntity(ClassicHttpResponse response) {
		checkRespondeCode(response);
		return response.getEntity();
	}

	private ObjectMapper chooseMapper(HttpResponse response) {
		Header contentTypeHeader;
		try {
			contentTypeHeader = response.getHeader("Content-Type");
		} catch (ProtocolException e) {
			throw new PlexException(e);
		}
		if (contentTypeHeader == null)
			throw new PlexException("Cannot determine mapper to use to deserialize entity. No Content-Type detected");
		String contentType = contentTypeHeader.getValue().toLowerCase();
		if (contentType.contains("xml"))
			return xmlMapper;
		if (contentType.contains("json"))
			return jsonMapper;
		throw new PlexException("Cannot determine mapper deserialize entity with Content-Type: " + contentType);
	}
}