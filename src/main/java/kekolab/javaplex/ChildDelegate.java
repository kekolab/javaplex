package kekolab.javaplex;

import java.net.URI;
import java.util.function.Supplier;

public class ChildDelegate<P extends PlexMediatag<?>> {
	private Supplier<PlexHTTPClient> client;
	private Supplier<String> token;

	private UriProvider parentKey, parentRatingKey, parentTheme, parentThumb;
	private String parentGuid;
	private Integer parentIndex;
	private String parentStudio;
	private String parentTitle;
	private Integer parentYear;
	private Supplier<PlexMediaServer> server;

	protected ChildDelegate(Supplier<PlexMediaServer> server, Supplier<PlexHTTPClient> client, Supplier<String> token) {
		parentKey = new UriProvider(() -> server.get().uri());
		parentRatingKey = new UriProvider(() -> server.get().uri());
		parentTheme = new UriProvider(() -> server.get().uri());
		parentThumb = new UriProvider(() -> server.get().uri());
		this.client = client;
		this.token = token;
		this.server = server;
	}

	protected void clear() {
		parentKey.setValue(null);
		parentRatingKey.setValue(null);
		parentTheme.setValue(null);
		parentThumb.setValue(null);
		parentGuid = null;
		parentIndex = null;
		parentStudio = null;
		parentTitle = null;
		parentYear = null;
	}

	protected void update(ChildDelegate<P> source)  {
		parentGuid = source.parentGuid;
		parentKey.setValue(source.parentKey.getValue());
		parentIndex = source.parentIndex;
		parentRatingKey.setValue(source.parentRatingKey.getValue());
		parentStudio = source.parentStudio;
		parentTheme.setValue(source.parentTheme.getValue());
		parentThumb.setValue(source.parentThumb.getValue());
		parentTitle = source.parentTitle;
		parentYear = source.parentYear;
	}

	
	public P parent()  {
		URI uri = parentKey() != null ? parentKey() : parentRatingKey() != null ? parentRatingKey() : null;
		if (uri != null)
			return new MetadataContainer<P, PlexDirectory>(uri, client.get(), token.get(), server.get()).getMetadata()
					.get(0); 
		return null;
	}

	
	public String getParentGuid()  {
		return parentGuid;
	}

	
	public Integer getParentIndex()  {
		return parentIndex;
	}

	
	public String getParentKey()  {
		return (String) parentKey.getValue();
	}

	
	public URI parentKey()  {
		return parentKey.uri();
	}

	
	public Integer getParentRatingKey()  {
		return (Integer) parentRatingKey.getValue();
	}

	
	public URI parentRatingKey()  {
		return parentRatingKey.uri();
	}

	
	public String getParentStudio()  {
		return parentStudio;
	}

	
	public String getParentTheme()  {
		return (String) parentTheme.getValue();
	}

	
	public URI parentTheme()  {
		return parentTheme.uri();
	}

	
	public String getParentThumb()  {
		return (String) parentThumb.getValue();
	}

	
	public URI parentThumb()  {
		return parentThumb.uri();
	}

	
	public String getParentTitle()  {
		return parentTitle;
	}

	
	public Integer getParentYear()  {
		return parentYear;
	}

	protected void setParentGuid(String guid) {
		this.parentGuid = guid;
	}

	protected void setParentIndex(Integer index) {
		this.parentIndex = index;
	}

	protected void setParentStudio(String studio) {
		this.parentStudio = studio;
	}

	protected void setParentTitle(String title) {
		this.parentTitle = title;
	}

	protected void setParentYear(Integer year) {
		this.parentYear = year;
	}

	protected void setParentKey(String key) {
		this.parentKey.setValue(key);
	}

	protected void setParentRatingKey(Integer ratingKey) {
		this.parentRatingKey.setValue(ratingKey);
	}

	protected void setParentThumb(String thumb) {
		this.parentThumb.setValue(thumb);
	}

	protected void setParentTheme(String theme) {
		this.parentTheme.setValue(theme);
	}
}
