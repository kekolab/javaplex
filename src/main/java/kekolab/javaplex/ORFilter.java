package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexFilter;

public class ORFilter extends CompositeFilter {
    protected ORFilter(List<PlexFilter> filters) {
        super(filters);
    }

    @Override
    public String getQueryString() {
        StringBuilder builder = new StringBuilder()
        .append("push=1&");
        getFilters().stream().map(PlexFilter::getQueryString).reduce((t, u) -> t.concat("&or=1&").concat(u)).ifPresent(builder::append);
        builder.append("&pop=1");
        return builder.toString();
    }
}