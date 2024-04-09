package kekolab.javaplex;

import java.util.List;

import org.apache.hc.core5.http.message.BasicNameValuePair;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeSecondaryDirectory;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexSectionQueryBuilder;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowSecondaryDirectory;
import kekolab.javaplex.model.PlexShowOrEpisodeSecondaryDirectory;
import kekolab.javaplex.model.PlexShowSection;

public class ShowSection extends Section implements PlexShowSection {

	@Override
	public PlexSectionQueryBuilder<PlexShow> all() {
		return new SectionQueryBuilder<PlexShow>()
				.withSection(this)
				.withPath("all");
	}

	@Override
	public List<PlexEpisode> recentlyAdded() {
		return new SectionQueryBuilder<PlexEpisode>()
				.withSection(this)
				.withPath("recentlyAdded")
				.execute();
	}

	@Override
	public List<PlexEpisode> newest() {
		return new SectionQueryBuilder<PlexEpisode>()
				.withSection(this)
				.withPath("newest")
				.execute();
	}

	@Override
	public List<PlexEpisode> onDeck() {
		return new SectionQueryBuilder<PlexEpisode>()
		.withSection(this)
		.withPath("onDeck")
		.execute();
	}

	@Override
	public List<PlexEpisode> recentlyViewed() {
		return new SectionQueryBuilder<PlexEpisode>()
				.withSection(this)
				.withPath("recentlyViewed")
				.execute();
	}

	@Override
	public List<PlexShow> recentlyViewedShows() {
		return new SectionQueryBuilder<PlexShow>()
				.withSection(this)
				.withPath("recentlyViewedShows")
				.execute();
	}

	@Override
	public List<PlexShow> unwatched() {
		return new SectionQueryBuilder<PlexShow>()
				.withSection(this)
				.withPath("unwatched")
				.execute();
	}

	@Override
	public PlexSectionQueryBuilder<PlexSeason> seasons() {
		return new SectionQueryBuilder<PlexSeason>()
				.withSection(this)
				.withPath("all")
				.addParameter(new BasicNameValuePair("type", Integer.toString(PlexSeason.TYPE_ID)));
	}

	@Override
	public PlexSectionQueryBuilder<PlexEpisode> episodes() {
		return new SectionQueryBuilder<PlexEpisode>()
				.withSection(this)
				.withPath("all")
				.addParameter(new BasicNameValuePair("type", Integer.toString(PlexEpisode.TYPE_ID)));
	}

	@Override
	public ShowCollections collections() {
		return new ShowCollections(this);
	}

	@Override
	public List<PlexShowSecondaryDirectory> byGenre() {
		return byFeature("genre", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowOrEpisodeSecondaryDirectory> byYear() {
		return byFeature("year", f -> new ShowOrEpisodeSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowSecondaryDirectory> byContentRating() {
		return byFeature("contentRating", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowSecondaryDirectory> byStudio() {
		return byFeature("studio", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowSecondaryDirectory> byNetwork() {
		return byFeature("network", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowSecondaryDirectory> byCountry() {
		return byFeature("country", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowOrEpisodeSecondaryDirectory> byCollection() {
		return byFeature("collection", f -> new ShowOrEpisodeSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowSecondaryDirectory> byDirector() {
		return byFeature("director", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowSecondaryDirectory> byActor() {
		return byFeature("actor", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowSecondaryDirectory> byWriter() {
		return byFeature("writer", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowSecondaryDirectory> byProducer() {
		return byFeature("producer", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexShowSecondaryDirectory> byLabel() {
		return byFeature("label", f -> new ShowSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexEpisodeSecondaryDirectory> byResolution() {
		return byFeature("resolution", f -> new EpisodeSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexEpisodeSecondaryDirectory> byAudioLanguage() {
		return byFeature("audioLanguage", f -> new EpisodeSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexEpisodeSecondaryDirectory> bySubtitleLanguage() {
		return byFeature("subtitleLanguage", f -> new EpisodeSecondaryDirectory(f, this));
	}
}
