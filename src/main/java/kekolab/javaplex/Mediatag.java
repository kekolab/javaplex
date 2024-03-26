package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexGuid;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexPlayer;
import kekolab.javaplex.model.PlexSection;
import kekolab.javaplex.model.PlexSession;
import kekolab.javaplex.model.PlexTag;
import kekolab.javaplex.model.PlexTranscodeSession;
import kekolab.javaplex.model.PlexUser;

abstract class Mediatag<S extends PlexSection<?, ?>> extends SectionItem<S> implements PlexMediatag<S> {
	private Boolean allowSync;
	@JsonProperty("Collection")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> collections;
	@JsonProperty("Guid")
	@JsonDeserialize(contentAs = Guid.class)
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
	// TODO Should I try to update them when requested?
	@JsonProperty("User")
	@JsonDeserialize(as = User.class)
	private PlexUser user;
	@JsonProperty("Player")
	@JsonDeserialize(as = Player.class)
	private PlexPlayer player;
	@JsonProperty("Session")
	@JsonDeserialize(as = Session.class)
	private PlexSession session;
	@JsonProperty("TranscodeSession")
	@JsonDeserialize(as = TranscodeSession.class)
	private PlexTranscodeSession transcodeSession;
	private Integer sessionKey;

	public Mediatag() {
		collections = new ArrayList<>();
		guids = new ArrayList<>();
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		Mediatag<?> mediatag = (Mediatag<?>) source;
		setAllowSync(mediatag.getAllowSync());
		setCollections(mediatag.getCollections());
		setGuids(mediatag.getGuids());
		setIndex(mediatag.getIndex());
		setLastRatedAt(mediatag.getLastRatedAt());
		setLastViewedAt(mediatag.getLastViewedAt());
		setPlaylistItemID(mediatag.getPlaylistItemID());
		setSkipCount(mediatag.getSkipCount());
		setUserRating(mediatag.getUserRating());
		setViewOffset(mediatag.getViewOffset());
	}

	public Boolean getAllowSync() {
		ensureDetailed(allowSync);
		return allowSync;
	}

	public void setAllowSync(Boolean allowSync) {
		this.allowSync = allowSync;
	}

	public Double getUserRating() {
		ensureDetailed(userRating);
		return userRating;
	}

	public void setUserRating(Double userRating) {
		this.userRating = userRating;
	}

	public Date getLastViewedAt() {
		ensureDetailed(lastViewedAt);
		return lastViewedAt;
	}

	public void setLastViewedAt(Date lastViewedAt) {
		this.lastViewedAt = lastViewedAt;
	}

	public Long getViewOffset() {
		ensureDetailed(viewOffset);
		return viewOffset;
	}

	public void setViewOffset(Long viewOffset) {
		this.viewOffset = viewOffset;
	}

	public Integer getSkipCount() {
		ensureDetailed(skipCount);
		return skipCount;
	}

	public void setSkipCount(Integer skipCount) {
		this.skipCount = skipCount;
	}

	public Integer getIndex() {
		ensureDetailed(index);
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getPlaylistItemID() {
		ensureDetailed(playlistItemID);
		return playlistItemID;
	}

	public void setPlaylistItemID(Integer playlistItemID) {
		this.playlistItemID = playlistItemID;
	}

	public List<PlexTag> getCollections() {
		ensureDetailed(collections);
		return collections;
	}

	public void setCollections(List<PlexTag> collections) {
		this.collections = collections;
	}

	public List<PlexGuid> getGuids() {
		ensureDetailed(guids);
		return guids;
	}

	public void setGuids(List<PlexGuid> guids) {
		this.guids = guids;
	}

	public Date getLastRatedAt() {
		ensureDetailed(lastRatedAt);
		return lastRatedAt;
	}

	public void setLastRatedAt(Date lastRatedAt) {
		this.lastRatedAt = lastRatedAt;
	}

	@Override
	public URI ratingKey() {
		if (getRatingKey() != null)
			try {
				return new URIBuilder(getServer().getUri())
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
			((TranscodeSession) transcodeSession).initialise(getServer(), uri());
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
	void ensureDetailed(Object field) {
		super.ensureDetailed(field);
		if (field instanceof List<?> list)
			list.stream().filter(MediatagAttribute.class::isInstance).map(MediatagAttribute.class::cast)
					.filter(a -> a.getParentTag() == null).forEach(a -> a.initialise(this));
	}

	URI serverSchemeUri() {
		try {
			return new URIBuilder().setScheme("server").setHost(getServer().getMachineIdentifier())
					.appendPath("com.plexapp.plugins.library").appendPath("library").appendPath("metadata")
					.appendPath(Integer.toString(getRatingKey())).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}
}
