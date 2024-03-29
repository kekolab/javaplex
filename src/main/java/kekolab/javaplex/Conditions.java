package kekolab.javaplex;

import java.util.Arrays;
import java.util.List;

import kekolab.javaplex.model.PlexCondition;

public class Conditions {
    // Music section filters
    // Artist filters
    public static StringConditions ifArtistTitle() {
        return new StringConditions("artist.title");
    }

    public static IntegerConditions ifArtistRating() {
        return new IntegerConditions("artist.userRating");
    }

    public static YesNoFilterConditions ifArtistGenre() {
        return new YesNoFilterConditions("artist.genre");
    }

    /**
     * @apiNote This does not work neither here or on the GUI
     */
    public static YesNoFilterConditions ifArtistCollection() {
        return new YesNoFilterConditions("artist.collection");
    }

    public static YesNoFilterConditions ifArtistCountry() {
        return new YesNoFilterConditions("artist.country");
    }

    public static YesNoFilterConditions ifArtistMood() {
        return new YesNoFilterConditions("artist.mood");
    }

    public static YesNoFilterConditions ifArtistStyle() {
        return new YesNoFilterConditions("artist.style");
    }

    public static DateConditions ifDateArtistAdded() {
        return new DateConditions("artist.addedAt");
    }

    public static DateConditions ifArtistLastPlayed() {
        return new DateConditions("artist.lastViewedAt");
    }

    public static BooleanConditions ifArtistUnmatched() {
        return new BooleanConditions("artist.unmatched");
    }
    // End of artist filters

    // Album filters
    public static StringConditions ifAlbumTitle() {
        return new StringConditions("album.title");
    }

    public static IntegerConditions ifAlbumYear() {
        return new IntegerConditions("album.year");
    }

    public static IntegerConditions ifAlbumDecade() {
        return new IntegerConditions("album.decade");
    }

    public static YesNoFilterConditions ifAlbumGenre() {
        return new YesNoFilterConditions("album.genre");
    }

    public static IntegerConditions ifAlbumPlays() {
        return new IntegerConditions("album.viewCount");
    }

    public static DateConditions ifAlbumLastPlayed() {
        return new DateConditions("album.lastViewedAt");
    }

    public static IntegerConditions ifAlbumRating() {
        return new IntegerConditions("album.userRating");
    }

    public static IntegerConditions ifAlbumCriticRating() {
        return new IntegerConditions("album.rating");
    }

    public static StringConditions ifAlbumRecordLabel() {
        return new StringConditions("album.studio");
    }

    public static YesNoFilterConditions ifAlbumMood() {
        return new YesNoFilterConditions("album.mood");
    }

    public static YesNoFilterConditions ifAlbumStyle() {
        return new YesNoFilterConditions("album.style");
    }

    public static YesNoFilterConditions ifAlbumFormat() {
        return new YesNoFilterConditions("album.format");
    }

    public static YesNoFilterConditions ifAlbumType() {
        return new YesNoFilterConditions("album.subformat");
    }

    public static YesNoFilterConditions ifAlbumCollection() {
        return new YesNoFilterConditions("album.collection");
    }

    public static DateConditions ifDateAlbumAdded() {
        return new DateConditions("album.addedAt");
    }

    public static DateConditions ifDateAlbumReleased() {
        return new DateConditions("album.originallyAvailableAt");
    }

    public static BooleanConditions ifAlbumUnmatched() {
        return new BooleanConditions("album.unmatched");
    }

    public static YesNoFilterConditions ifAlbumSource() {
        return new YesNoFilterConditions("album.source");
    }

    public static YesNoFilterConditions ifAlbumLabel() {
        return new YesNoFilterConditions("album.label");
    }
    // End of artist filters

    // Track filters
    public static YesNoFilterConditions ifTrackMood() {
        return new YesNoFilterConditions("track.mood");
    }

    public static StringConditions ifTrackTitle() {
        return new StringConditions("track.title");
    }

    public static IntegerConditions ifTrackPlays() {
        return new IntegerConditions("track.viewCount");
    }

    public static DateConditions ifTrackLastPlayed() {
        return new DateConditions("track.lastViewedAt");
    }

    public static IntegerConditions ifTrackSkips() {
        return new IntegerConditions("track.skipCount");
    }

    public static DateConditions ifTrackLastSkipped() {
        return new DateConditions("track.lastSkippedAt");
    }

    public static IntegerConditions ifTrackRating() {
        return new IntegerConditions("track.userRating");
    }

    public static DateConditions ifTrackLastRated() {
        return new DateConditions("track.lastRatedAt");
    }

    public static DateConditions ifTrackAddedDate() {
        return new DateConditions("track.addedAt");
    }

    public static IntegerConditions ifTrackFileSize() {
        return new IntegerConditions("track.mediaSize");
    }

    public static IntegerConditions ifTrackBitrate() {
        return new IntegerConditions("track.mediaBitrate");
    }

    public static BooleanConditions ifTrackTrashed() {
        return new BooleanConditions("track.trash");
    }

    public static YesNoFilterConditions ifTrackSource() {
        return new YesNoFilterConditions("track.source");
    }
    // End of track filters
    // End of music section filters

    // Begin movie section filters
    public static StringConditions ifMovieTitle() {
        return new StringConditions("title");
    }

    public static StringConditions ifMovieStudio() {
        return new StringConditions("studio");
    }

    public static IntegerConditions ifMovieRating() {
        return new IntegerConditions("userRating");
    }

    public static YesNoFilterConditions ifMovieContentRating() {
        return new YesNoFilterConditions("contentRating");
    }

    public static IntegerConditions ifMovieYear() {
        return new IntegerConditions("year");
    }

    public static IntegerConditions ifMovieDecade() {
        return new IntegerConditions("decade");
    }

    public static BooleanConditions ifMovieUnmatched() {
        return new BooleanConditions("unmatched");
    }

    public static BooleanConditions ifMovieDupliacated() {
        return new BooleanConditions("duplicated");
    }

    public static YesNoFilterConditions ifMovieGenre() {
        return new YesNoFilterConditions("genre");
    }

    public static YesNoFilterConditions ifMovieCollection() {
        return new YesNoFilterConditions("collection");
    }

    public static YesNoFilterConditions ifMovieDirector() {
        return new YesNoFilterConditions("director");
    }

    public static YesNoFilterConditions ifMovieWriter() {
        return new YesNoFilterConditions("writer");
    }

    public static YesNoFilterConditions ifMovieProducer() {
        return new YesNoFilterConditions("producer");
    }

    public static YesNoFilterConditions ifMovieActor() {
        return new YesNoFilterConditions("actor");
    }

    public static YesNoFilterConditions ifMovieCountry() {
        return new YesNoFilterConditions("country");
    }

    public static DateConditions ifMovieDateAdded() {
        return new DateConditions("addedAt");
    }

    public static IntegerConditions ifMoviePlays() {
        return new IntegerConditions("viewCount");
    }

    public static DateConditions ifMovieLastplayed() {
        return new DateConditions("lastViewedAt");
    }

    public static BooleanConditions ifMovieUnplayed() {
        return new BooleanConditions("unwatched");
    }

    public static YesOnlyFilterConditions ifMovieResolution() {
        return new YesNoFilterConditions("resolution");
    }

    public static BooleanConditions ifMovieHDR() {
        return new BooleanConditions("hdr");
    }

    public static IntegerConditions ifMovieFileSize() {
        return new IntegerConditions("mediaSize");
    }

    public static IntegerConditions ifMovieBitrate() {
        return new IntegerConditions("mediaBitrate");
    }

    public static YesNoFilterConditions ifMovieSubtitleLanguage() {
        return new YesNoFilterConditions("subtitleLanguage");
    }

    public static YesNoFilterConditions ifMovieAudioLanguage() {
        return new YesNoFilterConditions("audioLanguage");
    }

    public static BooleanConditions ifMovieInProgress() {
        return new BooleanConditions("inProgress");
    }

    public static BooleanConditions ifMovieTrashed() {
        return new BooleanConditions("trash");
    }

    public static YesNoFilterConditions ifMovieLabel() {
        return new YesNoFilterConditions("label");
    }
    // End of music section filters

    public static PlexCondition or(List<PlexCondition> filters) {
        return new ORCondition(filters);
    }

    public static PlexCondition or(PlexCondition... filters) {
        return or(Arrays.asList(filters));
    }

    public static PlexCondition and(List<PlexCondition> filters) {
        return new ANDCondition(filters);
    }

    public static PlexCondition and(PlexCondition... filters) {
        return and(Arrays.asList(filters));
    }

    private String field;
    private String operator;
    private String value;

    protected Conditions(String field) {
        this.field = field;
    }

    protected Conditions withOperator(String operator) {
        this.operator = operator;
        return this;
    }

    protected Conditions withValue(String value) {
        this.value = value;
        return this;
    }

    protected PlexCondition build() {
        return new Condition(field, operator, value);
    }
}