package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.TimestampDeserializer;

public abstract class PlexMediatag<S extends PlexSection<?, ?>> extends PlexSectionItem<S> {
	private Boolean allowSync;
	@JsonProperty("Collection")
	private List<PlexTag> collections;
	@JsonProperty("Guid")
	private List<PlexGuid> guids;
	private Integer index;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date lastRatedAt;
	private Date lastViewedAt;
	private Integer playlistItemID;
	private Integer skipCount;
	private Double userRating;
	private Long viewOffset;

	// Properties returned only when querying /status/sessions
	@JsonProperty("User")
	private PlexUser user;
	@JsonProperty("Player")
	private PlexPlayer player;
	@JsonProperty("Session")
	private PlexSession session;
	@JsonProperty("TranscodeSession")
	private PlexTranscodeSession transcodeSession;
	private Integer sessionKey;

	public PlexMediatag() {
		collections = new ArrayList<>();
		guids = new ArrayList<>();
	}

	@Override
	protected void clear() {
		super.clear();
		allowSync = null;
		collections.clear();
		guids.clear();
		index = null;
		lastRatedAt = null;
		lastViewedAt = null;
		playlistItemID = null;
		skipCount = null;
		userRating = null;
		viewOffset = null;
		user = null;
		player = null;
		session = null;
		transcodeSession = null;
		sessionKey = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexMediatag<?> mediatag) {
			allowSync = mediatag.allowSync;
			collections.clear();
			collections.addAll(mediatag.collections);
			guids.clear();
			guids.addAll(mediatag.guids);
			index = mediatag.index;
			lastRatedAt = mediatag.lastRatedAt;
			lastViewedAt = mediatag.lastViewedAt;
			playlistItemID = mediatag.playlistItemID;
			skipCount = mediatag.skipCount;
			userRating = mediatag.userRating;
			viewOffset = mediatag.viewOffset;
			user = mediatag.user;
			player = mediatag.player;
			session = mediatag.session;
			transcodeSession = mediatag.transcodeSession;
			sessionKey = mediatag.sessionKey;			
		} else
			throw new ClassCastException("Cannot cast item to PlexMediatag");
	}

	/**
	 * The method:
	 * <ul>
	 * <li>verifies whether the attribute is instance of
	 * {@link MediatagAttribute}</li>
	 * <li>if it is a {@link MediatagAttribute} verifies whether
	 * {@link MediatagAttribute#getParentTag()} is {@code null}</li>
	 * <li>if it is {@code null}, calls
	 * {@link MediatagAttribute#initialise(PlexMediatag)} passing {@code this} as
	 * argument
	 * </ul>
	 * 
	 * @param attributes the attributes to process
	 */
	protected void initMediatagAttributes(List<?> attributes) {
		attributes.stream().filter(MediatagAttribute.class::isInstance).map(MediatagAttribute.class::cast)
				.filter(a -> a.getParentTag() == null).forEach(a -> a.initialise(this));
	}

	public Boolean getAllowSync() {
		fetchDetailedIfNullOrEmpty(allowSync);
		return allowSync;
	}

	public void setAllowSync(Boolean allowSync) {
		this.allowSync = allowSync;
	}

	public Double getUserRating() {
		fetchDetailedIfNullOrEmpty(userRating);
		return userRating;
	}

	public void setUserRating(Double userRating) {
		this.userRating = userRating;
	}

	public Date getLastViewedAt() {
		fetchDetailedIfNullOrEmpty(lastViewedAt);
		return lastViewedAt;
	}

	public void setLastViewedAt(Date lastViewedAt) {
		this.lastViewedAt = lastViewedAt;
	}

	public Long getViewOffset() {
		fetchDetailedIfNullOrEmpty(viewOffset);
		return viewOffset;
	}

	public void setViewOffset(Long viewOffset) {
		this.viewOffset = viewOffset;
	}

	public Integer getSkipCount() {
		fetchDetailedIfNullOrEmpty(skipCount);
		return skipCount;
	}

	public void setSkipCount(Integer skipCount) {
		this.skipCount = skipCount;
	}

	public Integer getIndex() {
		fetchDetailedIfNullOrEmpty(index);
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getPlaylistItemID() {
		fetchDetailedIfNullOrEmpty(playlistItemID);
		return playlistItemID;
	}

	public void setPlaylistItemID(Integer playlistItemID) {
		this.playlistItemID = playlistItemID;
	}

	public List<PlexTag> getCollections() {
		fetchDetailedIfNullOrEmpty(collections);
		return collections;
	}

	public void setCollections(List<PlexTag> collections) {
		this.collections = collections;
	}

	public List<PlexGuid> getGuids() {
		fetchDetailedIfNullOrEmpty(guids);
		return guids;
	}

	public void setGuids(List<PlexGuid> guids) {
		this.guids = guids;
	}

	public Date getLastRatedAt() {
		fetchDetailedIfNullOrEmpty(lastRatedAt);
		return lastRatedAt;
	}

	public void setLastRatedAt(Date lastRatedAt) {
		this.lastRatedAt = lastRatedAt;
	}

	@Override
	public URI ratingKey() {
		if (getRatingKey() != null)
			try {
				return new URIBuilder(server().uri())
						.appendPathSegments("library", "metadata", Integer.toString(getRatingKey())).build();
			} catch (URISyntaxException e) {
				throw new PlexException(e);
			}
		return null;
	}

	public PlexUser getUser() {
		return user;
	}

	public void setUser(PlexUser user) {
		this.user = user;
	}

	public PlexPlayer getPlayer() {
		return player;
	}

	public void setPlayer(PlexPlayer player) {
		this.player = player;
	}

	public PlexSession getSession() {
		return session;
	}

	public void setSession(PlexSession session) {
		this.session = session;
	}

	public PlexTranscodeSession getTranscodeSession() {
		if (transcodeSession != null)
			transcodeSession.initialise(server(), uri(), getClient(), getToken());
		return transcodeSession;
	}

	public void setTranscodeSession(PlexTranscodeSession transcodeSession) {
		this.transcodeSession = transcodeSession;
	}
	
	public Integer getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(Integer sessionKey) {
		this.sessionKey = sessionKey;
	}


	@Override
	protected void fetchDetailedIfNullOrEmpty(Object argument) {
		super.fetchDetailedIfNullOrEmpty(argument);
		if (argument instanceof List<?>)
			initMediatagAttributes((List<?>) argument);
	}

	protected URI serverSchemeUri() {
		try {
			return new URIBuilder().setScheme("server").setHost(server().getMachineIdentifier())
					.appendPath("com.plexapp.plugins.library").appendPath("library").appendPath("metadata")
					.appendPath(Integer.toString(getRatingKey())).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}

	protected void editTaglist(FieldEditor<List<PlexTag>> editor, List<PlexTag> value) {
		editor.setValue(value);
	}
}
