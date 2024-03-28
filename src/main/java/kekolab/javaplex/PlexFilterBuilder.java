package kekolab.javaplex;

import java.util.Arrays;
import java.util.List;

import kekolab.javaplex.model.PlexFilter;

public class PlexFilterBuilder {

    // Music section filters
    // Artist filters
    public static StringFilterBuilder whereArtistTitle() {
        return new StringFilterBuilder("artist.title");
    }

    public static IntegerFilterBuilder whereArtistUserRating() {
        return new IntegerFilterBuilder("artist.userRating");
    }

    public static TagFilterBuilder whereArtistGenre() {
        return new TagFilterBuilder("artist.genre");
    }

    /**
     * @apiNote This does not work neither here or on the GUI
     */
    public static TagFilterBuilder whereArtistCollection() {
        return new TagFilterBuilder("artist.collection");
    }

    public static TagFilterBuilder whereArtistCountry() {
        return new TagFilterBuilder("artist.country");
    }

    public static TagFilterBuilder whereArtistMood() {
        return new TagFilterBuilder("artist.mood");
    }

    public static TagFilterBuilder whereArtistStyle() {
        return new TagFilterBuilder("artist.style");
    }

    public static DateFilterBuilder whereDateArtistAdded() {
        return new DateFilterBuilder("artist.addedAt");
    }

    public static DateFilterBuilder whereArtistLastPlayed() {
        return new DateFilterBuilder("artist.lastViewedAt");
    }

    public static BooleanFilterBuilder whereArtistUnmatched() {
        return new BooleanFilterBuilder("artist.unmatched");
    }
    // End of artist filters

    // Album filters
    public static StringFilterBuilder whereAlbumTitle() {
        return new StringFilterBuilder("album.title");
    }

    public static IntegerFilterBuilder whereAlbumYear() {
        return new IntegerFilterBuilder("album.year");
    }

    public static IntegerFilterBuilder whereAlbumDecade() {
        return new IntegerFilterBuilder("album.decade");
    }

    public static TagFilterBuilder whereAlbumGenre() {
        return new TagFilterBuilder("album.genre");
    }

    public static IntegerFilterBuilder whereAlbumViewCount() {
        return new IntegerFilterBuilder("album.viewCount");
    }

    public static DateFilterBuilder whereAlbumLastPlayed() {
        return new DateFilterBuilder("album.lastViewedAt");
    }

    public static IntegerFilterBuilder whereAlbumUserRating() {
        return new IntegerFilterBuilder("album.userRating");
    }

    public static IntegerFilterBuilder whereAlbumRating() {
        return new IntegerFilterBuilder("album.rating");
    }

    public static StringFilterBuilder whereAlbumStudio() {
        return new StringFilterBuilder("album.studio");
    }

    public static TagFilterBuilder whereAlbumMood() {
        return new TagFilterBuilder("album.mood");
    }

    public static TagFilterBuilder whereAlbumStyle() {
        return new TagFilterBuilder("album.style");
    }

    public static TagFilterBuilder whereAlbumFormat() {
        return new TagFilterBuilder("album.format");
    }

    public static TagFilterBuilder whereAlbumSubFormat() {
        return new TagFilterBuilder("album.subformat");
    }

    public static TagFilterBuilder whereAlbumCollection() {
        return new TagFilterBuilder("album.collection");
    }

    public static DateFilterBuilder whereAlbumAddedAt() {
        return new DateFilterBuilder("album.addedAt");
    }

    public static BooleanFilterBuilder whereAlbumUnmatched() {
        return new BooleanFilterBuilder("album.unmatched");
    }

    public static TagFilterBuilder whereAlbumSource() {
        return new TagFilterBuilder("album.source");
    }

    public static TagFilterBuilder whereAlbumLabel() {
        return new TagFilterBuilder("album.label");
    }
    // End of artist filters

    // Track filters
    public static TagFilterBuilder whereTrackMood() {
        return new TagFilterBuilder("track.mood");
    }

    public static StringFilterBuilder whereTrackTitle() {
        return new StringFilterBuilder("track.title");
    }

    public static IntegerFilterBuilder whereTrackViewCount() {
        return new IntegerFilterBuilder("track.viewCount");
    }

    public static DateFilterBuilder whereTrackLastPlayed() {
        return new DateFilterBuilder("track.lastViewedAt");
    }

    public static IntegerFilterBuilder whereTrackSkipCount() {
        return new IntegerFilterBuilder("track.skipCount");
    }

    public static DateFilterBuilder whereTrackLastSkippedAt() {
        return new DateFilterBuilder("track.lastSkippedAt");
    }

    public static IntegerFilterBuilder whereTrackUserRating() {
        return new IntegerFilterBuilder("track.userRating");
    }

    public static DateFilterBuilder whereTrackLastRatedAt() {
        return new DateFilterBuilder("track.lastRatedAt");
    }

    public static DateFilterBuilder whereTrackAddedAt() {
        return new DateFilterBuilder("track.addedAt");
    }

    public static IntegerFilterBuilder whereTrackFileSize() {
        return new IntegerFilterBuilder("track.mediaSize");
    }

    public static IntegerFilterBuilder whereTrackBitrate() {
        return new IntegerFilterBuilder("track.mediaBitrate");
    }

    public static BooleanFilterBuilder whereTrackTrashed() {
        return new BooleanFilterBuilder("track.trash");
    }

    public static TagFilterBuilder whereTrackSource() {
        return new TagFilterBuilder("track.source");
    }
    // End of track filters
    // End of music section filters

    public static PlexFilter or(List<PlexFilter> filters) {
        return new ORFilter(filters);
    }

    public static PlexFilter or(PlexFilter... filters) {
        return or(Arrays.asList(filters));
    }

    public static PlexFilter and(List<PlexFilter> filters) {
        return new ANDFilter(filters);
    }

    public static PlexFilter and(PlexFilter... filters) {
        return and(Arrays.asList(filters));
    }

    private String field;
    private String operator;
    private String value;

    protected PlexFilterBuilder(String field) {
        this.field = field;
    }

    protected PlexFilterBuilder withOperator(String operator) {
        this.operator = operator;
        return this;
    }

    protected PlexFilterBuilder withValue(String value) {
        this.value = value;
        return this;
    }

    protected PlexFilter build() {
        return new Filter(field, operator, value);
    }
}