package kekolab.javaplex;

import kekolab.javaplex.model.PlexFilter;

public class StringFilterBuilder extends PlexFilterBuilder {

    protected StringFilterBuilder(String field) {
        super(field);
    }

    public PlexFilter is(String value) {
        return super.withOperator("==").withValue(value).build();
    }

    public PlexFilter isNot(String value) {
        return super.withOperator("!==").withValue(value).build();
    }
    
    public PlexFilter contains(String value) {
        return super.withOperator("=").withValue(value).build();
    }
    
    public PlexFilter doesNotContain(String value) {
        return super.withOperator("!=").withValue(value).build();
    }

    public PlexFilter beginsWith(String value) {
        return super.withOperator("<=").withValue(value).build();
    }
    
    public PlexFilter endsWith(String value) {
        return super.withOperator(">=").withValue(value).build();
    }
}