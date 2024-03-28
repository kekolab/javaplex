package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexFilter;

public abstract class CompositeFilter implements PlexFilter {
    private List<PlexFilter> filters;

    protected CompositeFilter(List<PlexFilter> filters) {
        this.filters = filters;
    }

    protected List<PlexFilter> getFilters() {
        return filters;
    }
}