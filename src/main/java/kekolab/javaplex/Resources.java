package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import kekolab.javaplex.model.PlexDevice;
import kekolab.javaplex.model.PlexResources;

public class Resources extends MediaContainer implements PlexResources {
	private static final URI URI;

	static {
		try {
			URI = new URIBuilder("https://plex.tv/api/resources.xml").addParameter("includeHttps", "1")
					.addParameter("includeRelays", "1").build();
		} catch (URISyntaxException e) {
			throw new PlexException("Unknown exception. Please see attached stacktrace", e);
		}
	}

	@JsonProperty("Device")
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonDeserialize(contentAs = Device.class)
	private List<PlexDevice> devices;

	Resources(PlexHTTPClient client, String token) {
		super(URI, client, Optional.of(token));
		devices = new ArrayList<>();
	}

	@Override
	public List<PlexDevice> getDevices() {
		ensureFetched(devices);
		devices.forEach(d -> ((Device) d).setClient(getClient()));
		return devices;
	}

	public void setDevices(List<PlexDevice> devices) {
		this.devices = devices;
	}

	@Override
	public List<PlexDevice> list() {
		return getDevices();
	}
}