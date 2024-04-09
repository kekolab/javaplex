package kekolab.javaplex.model;

import java.util.List;

public interface PlexSectionQueryBuilder<ResultType extends PlexMediatag> {

    PlexSectionQueryBuilder<ResultType> filtered(PlexFilter filter);

    PlexSectionQueryBuilder<ResultType> sorted(String by);

    List<ResultType> execute();
}