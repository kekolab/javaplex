package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.TimestampDeserializer;

public abstract class PlexPlaylist<M extends PlexMediatag<?>> extends PlexMetadata {
	public static final String TYPE_DESCRIPTION = "playlist";

	private Long duration;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date lastViewedAt;
	private Integer leafCount;
	private String playlistType;
	private Boolean smart;
	private UriProvider art;
	private UriProvider thumb;
	private UriProvider composite;

	@JsonIgnore
	private FieldEditor<String> titleEditor;
	@JsonIgnore
	private FieldEditor<String> summaryEditor;

	public PlexPlaylist() {
		art = new UriProvider(this::uri);
		composite = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
		titleEditor = new StringFieldEditor("title", this::getTitle, false);
		summaryEditor = new StringFieldEditor("summary", this::getSummary, true);
	}

	@Override
	protected void clear() {
		super.clear();
		art.setValue(null);
		composite.setValue(null);
		duration = null;
		lastViewedAt = null;
		leafCount = null;
		playlistType = null;
		smart = null;
		thumb.setValue(null);
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexPlaylist playlist) {
			art.setValue(playlist.art.getValue());
			composite.setValue(playlist.composite.getValue());
			duration = playlist.duration;
			lastViewedAt = playlist.lastViewedAt;
			leafCount = playlist.leafCount;
			playlistType = playlist.playlistType;
			smart = playlist.smart;
			thumb.setValue(playlist.thumb.getValue());
		} else
			throw new ClassCastException("Cannot cast item to PlexPlaylist");
	}

	public Boolean getSmart() {
		return smart;
	}

	public void setSmart(Boolean smart) {
		this.smart = smart;
	}

	public String getPlaylistType() {
		return playlistType;
	}

	public void setPlaylistType(String playlistType) {
		this.playlistType = playlistType;
	}

	public Date getLastViewedAt() {
		return lastViewedAt;
	}

	public void setLastViewedAt(Date lastViewedAt) {
		this.lastViewedAt = lastViewedAt;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Integer getLeafCount() {
		return leafCount;
	}

	public void setLeafCount(Integer leafCount) {
		this.leafCount = leafCount;
	}

	public String getComposite() {
		return (String) composite.getValue();
	}

	public URI composite() {
		return composite.uri();
	}

	public void setComposite(String composite) {
		this.composite.setValue(composite);
	}

	public List<M> children() {
		return new MetadataContainer<M, PlexDirectory>(key(), getClient(), getToken(), server()).getMetadata();
	}

	private Integer itemId(M item) {
		Integer id = item.getPlaylistItemID();
		if (id != null)
			return id;

		// The passed item has no playlistitemid. We look for the child with
		// the same rating key and take the its playlistItemId
		return children().stream().filter(c -> c.getRatingKey().equals(item.getRatingKey()))
				.map(c -> c.getPlaylistItemID()).findAny().orElse(null);
	}

	public void remove(M item) {
		Integer playlistItemId = itemId(item);
		if (playlistItemId == null)
			return;

		URI uri;
		try {
			uri = new URIBuilder(key()).appendPath(Integer.toString(playlistItemId)).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		new GenericCollectionsHelper(this).remove(uri);
	}

	@Override
	public URI ratingKey() {
		if (getRatingKey() != null)
			try {
				return new URIBuilder(server().uri()).appendPathSegments("playlists", Integer.toString(getRatingKey()))
						.build();
			} catch (URISyntaxException e) {
				throw new PlexException(e);
			}
		return null;
	}

	public void delete() {
		new GenericCollectionsHelper(this).delete();
	}

	public void add(M mediatag) {
		new GenericCollectionsHelper(this).add(mediatag);
	}

	public String getArt() {
		fetchDetailedIfNullOrEmpty(art.getValue());
		return (String) art.getValue();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public URI art() {
		fetchDetailedIfNullOrEmpty(art.getValue());
		return art.uri();
	}

	public String getThumb() {
		fetchDetailedIfNullOrEmpty(thumb.getValue());
		return (String) thumb.getValue();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	public URI thumb() {
		fetchDetailedIfNullOrEmpty(thumb.getValue());
		return thumb.uri();
	}

	protected URI editUri() {
		return ratingKey();
	}

	public void editTitle(String title) {
		titleEditor.setValue(title);
	}

	public void editSummary(String summary) {
		summaryEditor.setValue(summary);
	}

	protected List<FieldEditor<?>> fieldEditors() {
		return Arrays.asList(new FieldEditor<?>[] {
				titleEditor, summaryEditor
		});
	}

	public void commitEdits() {
		new AttributeEditor(this).commit();
	}
}
