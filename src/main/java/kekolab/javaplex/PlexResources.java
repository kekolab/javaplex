package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class PlexResources extends PlexMediaContainer {
	@JsonIgnore
	private static URI uri;

	@JsonProperty("Device")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexDevice> devices;

	public List<PlexDevice> getDevices() {
		fetch();
		devices.stream().filter(PlexDevice.class::isInstance).map(PlexDevice.class::cast)
				.forEach(d -> d.setClient(client()));
		return devices;
	}

	public PlexResources(PlexHTTPClient client, String token) {
		super(buildUri(), client, token);
		devices = new ArrayList<>();
	}

	@Override
	protected void clear() {
		super.clear();
		devices.clear();
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexResources resources) {
			devices.clear();
			devices.addAll(resources.devices);
		} else
			throw new ClassCastException("Cannot cast source to PlexResources");
	}

	public void setDevices(List<PlexDevice> devices) {
		this.devices = devices;
	}

	private static URI buildUri() {
		if (uri == null)
			try {
				uri = new URIBuilder("https://plex.tv/api/resources.xml").addParameter("includeHttps", "1")
						.addParameter("includeRelays", "1").build();
			} catch (URISyntaxException e) {
				throw new PlexException(e);
			}
		return uri;
	}
}