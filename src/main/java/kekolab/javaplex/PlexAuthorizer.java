package kekolab.javaplex;

import java.util.Objects;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

public class PlexAuthorizer {
    private static final String URI_PIN_REQUEST = "https://plex.tv/pins.xml";
    private static final String BASE_URI_PIN_VERIFICATION = "https://plex.tv/pins/";
	
	private PlexHTTPClient client;

	public PlexAuthorizer(PlexHTTPClient client) {
		Objects.requireNonNull(client, "client cannot be null");
		this.client = client;
	}

	public PlexPin requestAuthenticationPin() {
    	ClassicHttpRequest request = ClassicRequestBuilder
    			.post(URI_PIN_REQUEST)
    			.build();
    	return client.executeAndCreateFromResponse(request, PlexPin.class, null);
    }
    
	public PlexPin verify(PlexPin pin)  {
		ClassicHttpRequest request = ClassicRequestBuilder
				.get(BASE_URI_PIN_VERIFICATION + pin.getId() + ".xml")
				.build();
		return client.executeAndUpdateFromResponse(request, pin, null);
	}
}
