package kekolab.javaplex;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kekolab.javaplex.filtering.PlexFilter;

public class PlexSmartPlaylist<S extends PlexSection, M extends PlexMediatag<S>> extends PlexPlaylist<M> {
	private String content;

	public String getContent() {
		ensureDetailed(content);
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	void update(PlexMetadata source) {
		super.update(source);
		PlexSmartPlaylist<?, ?> p = (PlexSmartPlaylist<?, ?>) source;
		setContent(p.getContent());
	}

	public S section() {
		Matcher matcher = Pattern.compile(".*/(\\d+)/.*").matcher(contentURIBuilder().getPath());
		if (matcher.matches())
			return (S) getServer().library().section(Integer.parseInt(matcher.group(1)));

		throw new PlexException("Cannot determine section for PlexSmartPlaylist");
	}

	private URIBuilder contentURIBuilder() {
		try {
			return new URIBuilder(URLDecoder.decode(getContent(), "UTF-8"));
		} catch (UnsupportedEncodingException | URISyntaxException e) {
			throw new PlexException(e);
		}
	}

	@JsonIgnore
	public Optional<String> getSort() {
		return contentURIBuilder().getQueryParams().stream().filter(p -> p.getName().toLowerCase().equals("sort"))
				.map(NameValuePair::getValue).findAny();
	}

	public PlexFilter getFilter() {
		List<NameValuePair> queryParams = contentURIBuilder().getQueryParams();
		queryParams.removeIf(p -> p.getName().toLowerCase().equals("type") || p.getName().toLowerCase().equals("sort"));
		PlexFilter filter = PlexFilter.parse(queryParams);

		try {
			System.out.println(getContent());
			System.out.println("DECODING");
			System.out.println(URLDecoder.decode(getContent(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DECODED");
		System.out.println(filter.getQueryParameters().stream().map(p -> p.getName() + "=" + p.getValue())
				.reduce((a, b) -> a.concat("&").concat(b)).get());
		;

		return filter; // TODO
	}
}
