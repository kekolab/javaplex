package kekolab.javaplex;

import java.net.URI;
import java.util.function.Supplier;

public class GrandchildDelegate<P extends PlexMediatag<?>, GP extends PlexMediatag<?>> extends ChildDelegate<P> {
	private Supplier<PlexHTTPClient> client;
	private Supplier<String> token;

	private UriProvider grandparentArt, grandparentKey, grandparentRatingKey, grandparentTheme, grandparentThumb;
	private String guid;
	private String title;
	private Integer year;
	private Supplier<PlexMediaServer> server;

	protected GrandchildDelegate(Supplier<PlexMediaServer> server, Supplier<PlexHTTPClient> client,
			Supplier<String> token) {
		super(server, client, token);
		grandparentArt = new UriProvider(() -> server.get().uri());
		grandparentKey = new UriProvider(() -> server.get().uri());
		grandparentRatingKey = new UriProvider(() -> server.get().uri());
		grandparentTheme = new UriProvider(() -> server.get().uri());
		grandparentThumb = new UriProvider(() -> server.get().uri());
		this.server = server;
		this.client = client;
		this.token = token;
	}

	protected void clear() {
		grandparentArt.setValue(null);
		grandparentKey.setValue(null);
		grandparentRatingKey.setValue(null);
		grandparentTheme.setValue(null);
		grandparentThumb.setValue(null);
		guid = null;
		title = null;
		year = null;
	}

	protected void update(GrandchildDelegate<P, GP> source)  {
		super.update(source);
		grandparentArt = source.grandparentArt;
		grandparentKey = source.grandparentKey;
		grandparentRatingKey = source.grandparentRatingKey;
		grandparentTheme = source.grandparentTheme;
		grandparentThumb = source.grandparentThumb;
		guid = source.guid;
		title = source.title;
		year = source.year;
	}

	
	public GP grandparent()  {
		URI uri = grandparentKey() != null ? grandparentKey()
				: grandparentRatingKey() != null ? grandparentRatingKey() : null;
		if (uri != null)
			return new MetadataContainer<GP, PlexDirectory>(uri, client.get(), token.get(), server.get()).getMetadata()
					.get(0);
		return null;
	}

	
	public String getGrandparentArt()  {
		return (String) grandparentArt.getValue();
	}

	
	public URI grandparentArt()  {
		return grandparentArt.uri();
	}

	
	public String getGrandparentGuid()  {
		return guid;
	}

	
	public String getGrandparentKey()  {
		return (String) grandparentKey.getValue();
	}

	
	public URI grandparentKey()  {
		return grandparentKey.uri();
	}

	
	public Integer getGrandparentRatingKey()  {
		return (Integer) grandparentRatingKey.getValue();
	}

	
	public URI grandparentRatingKey()  {
		return grandparentRatingKey.uri();
	}

	
	public String getGrandparentTheme()  {
		return (String) grandparentTheme.getValue();
	}

	
	public URI grandparentTheme()  {
		return grandparentTheme.uri();
	}

	
	public String getGrandparentThumb()  {
		return (String) grandparentThumb.getValue();
	}

	
	public URI grandparentThumb()  {
		return grandparentThumb.uri();
	}

	
	public String getGrandparentTitle()  {
		return title;
	}

	
	public Integer getGrandparentYear()  {
		return year;
	}

	protected void setGrandparentGuid(String guid) {
		this.guid = guid;
	}

	protected void setGrandparentTitle(String title) {
		this.title = title;
	}

	protected void setGrandparentYear(Integer year) {
		this.year = year;
	}

	protected void setGrandparentArt(String art) {
		this.grandparentArt.setValue(art);
	}

	protected void setGrandparentKey(String key) {
		this.grandparentKey.setValue(key);
	}

	protected void setGrandparentRatingKey(Integer ratingKey) {
		this.grandparentKey.setValue(ratingKey);
	}

	protected void setGrandparentTheme(String theme) {
		this.grandparentKey.setValue(theme);
	}

	protected void setGrandparentThumb(String thumb) {
		this.grandparentKey.setValue(thumb);
	}
}
