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

    public static IntegerConditions ifArtistUserRating() {
        return new IntegerConditions("artist.userRating");
    }

    public static FilterConditions ifArtistGenre() {
        return new FilterConditions("artist.genre");
    }

    /**
     * @apiNote This does not work neither here or on the GUI
     */
    public static FilterConditions ifArtistCollection() {
        return new FilterConditions("artist.collection");
    }

    public static FilterConditions ifArtistCountry() {
        return new FilterConditions("artist.country");
    }

    public static FilterConditions ifArtistMood() {
        return new FilterConditions("artist.mood");
    }

    public static FilterConditions ifArtistStyle() {
        return new FilterConditions("artist.style");
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

    public static FilterConditions ifAlbumGenre() {
        return new FilterConditions("album.genre");
    }

    public static IntegerConditions ifAlbumViewCount() {
        return new IntegerConditions("album.viewCount");
    }

    public static DateConditions ifAlbumLastPlayed() {
        return new DateConditions("album.lastViewedAt");
    }

    public static IntegerConditions ifAlbumUserRating() {
        return new IntegerConditions("album.userRating");
    }

    public static IntegerConditions ifAlbumRating() {
        return new IntegerConditions("album.rating");
    }

    public static StringConditions ifAlbumStudio() {
        return new StringConditions("album.studio");
    }

    public static FilterConditions ifAlbumMood() {
        return new FilterConditions("album.mood");
    }

    public static FilterConditions ifAlbumStyle() {
        return new FilterConditions("album.style");
    }

    public static FilterConditions ifAlbumFormat() {
        return new FilterConditions("album.format");
    }

    public static FilterConditions ifAlbumSubFormat() {
        return new FilterConditions("album.subformat");
    }

    public static FilterConditions ifAlbumCollection() {
        return new FilterConditions("album.collection");
    }

    public static DateConditions ifAlbumAddedAt() {
        return new DateConditions("album.addedAt");
    }

    public static BooleanConditions ifAlbumUnmatched() {
        return new BooleanConditions("album.unmatched");
    }

    public static FilterConditions ifAlbumSource() {
        return new FilterConditions("album.source");
    }

    public static FilterConditions ifAlbumLabel() {
        return new FilterConditions("album.label");
    }
    // End of artist filters

    // Track filters
    public static FilterConditions ifTrackMood() {
        return new FilterConditions("track.mood");
    }

    public static StringConditions ifTrackTitle() {
        return new StringConditions("track.title");
    }

    public static IntegerConditions ifTrackViewCount() {
        return new IntegerConditions("track.viewCount");
    }

    public static DateConditions ifTrackLastPlayed() {
        return new DateConditions("track.lastViewedAt");
    }

    public static IntegerConditions ifTrackSkipCount() {
        return new IntegerConditions("track.skipCount");
    }

    public static DateConditions ifTrackLastSkippedAt() {
        return new DateConditions("track.lastSkippedAt");
    }

    public static IntegerConditions ifTrackUserRating() {
        return new IntegerConditions("track.userRating");
    }

    public static DateConditions ifTrackLastRatedAt() {
        return new DateConditions("track.lastRatedAt");
    }

    public static DateConditions ifTrackAddedAt() {
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

    public static FilterConditions ifTrackSource() {
        return new FilterConditions("track.source");
    }
    // End of track filters
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