package kekolab.javaplex;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexSectionQueryBuilder;

public class SectionQueryBuilder<ResultType extends PlexMediatag> implements PlexSectionQueryBuilder<ResultType> {
	private Section section;
	private String path;
	private PlexFilter filter;
	private String sort;
	private List<NameValuePair> parameters;

	protected SectionQueryBuilder() {
		this.parameters = new ArrayList<>();
	}

	protected SectionQueryBuilder<ResultType> addParameter(NameValuePair parameter) {
		this.parameters.add(parameter);
		return this;
	}

	protected SectionQueryBuilder<ResultType> withSection(Section section) {
		this.section = section;
		return this;
	}

	protected SectionQueryBuilder<ResultType> withPath(String path) {
		this.path = path;
		return this;
	}

	@Override
	public SectionQueryBuilder<ResultType> filtered(PlexFilter condition) {
		this.filter = condition;
		return this;
	}

	@Override
	public SectionQueryBuilder<ResultType> sorted(String sort) {
		this.sort = sort;
		return this;
	}

	@Override
	public List<ResultType> execute() {
		URIBuilder uri = new URIBuilder(section.key()).appendPath(path);
		uri.addParameters(parameters);
		if (filter != null)
			uri.addParameters(filter.getQueryParameters());
		if (sort != null)
			uri.addParameter("sort", sort);

		try {
			return new MetadataContainer<ResultType, Directory>(uri.build(), section.getServer()).getMetadata();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}
}