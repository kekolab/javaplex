package kekolab.javaplex.model;

import kekolab.javaplex.model.PlexBaseFilter.Operator;

public class PlexBooleanFilterBuilder {
    private final PlexFilterableBoolean field;

    public PlexBooleanFilterBuilder(PlexFilterableBoolean field) {
        this.field = field;
    }

    public PlexFilter isTrue() {
        return new PlexBaseFilter(field.getName(), Operator.IS_OR_CONTAINS, "1");
    }

    public PlexFilter isFalse() {
        return new PlexBaseFilter(field.getName(), Operator.IS_NOT_OR_DOES_NOT_CONTAIN, "1");
    }
}