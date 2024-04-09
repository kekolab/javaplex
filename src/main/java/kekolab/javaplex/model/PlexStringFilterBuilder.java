package kekolab.javaplex.model;

import kekolab.javaplex.model.PlexBaseFilter.Operator;

public class PlexStringFilterBuilder {
    private final PlexFilterableString field;

    public PlexStringFilterBuilder(PlexFilterableString field) {
        this.field = field;
    }

    public PlexFilter contains(String value) {
        return new PlexBaseFilter(field.getName(), Operator.IS_OR_CONTAINS, value);
    }

    public PlexFilter doesNotContain(String value) {
        return new PlexBaseFilter(field.getName(), Operator.IS_NOT_OR_DOES_NOT_CONTAIN, value);
    }

    public PlexFilter equals(String value) {
        return new PlexBaseFilter(field.getName(), Operator.STRING_EQUALS, value);
    }

    public PlexFilter doesNotEqual(String value) {
        return new PlexBaseFilter(field.getName(), Operator.STRING_DOES_NOT_EQUAL, value);
    }

    public PlexFilter beginsWith(String value) {
        return new PlexBaseFilter(field.getName(), Operator.BEGINS_WITH, value);
    }

    public PlexFilter endsWith(String value) {
        return new PlexBaseFilter(field.getName(), Operator.ENDS_WITH, value);
    }
}