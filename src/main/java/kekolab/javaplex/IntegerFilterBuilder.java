package kekolab.javaplex;

import kekolab.javaplex.model.PlexFilter;

public class IntegerFilterBuilder extends PlexFilterBuilder {

    protected IntegerFilterBuilder(String field) {
        super(field);
    }

    public PlexFilter is(Integer value) {
        return super.withOperator("=").withValue(Integer.toString(value)).build();
    }

    public PlexFilter isNot(Integer value) {
        return super.withOperator("!=").withValue(Integer.toString(value)).build();
    }

    public PlexFilter isGreaterThan(Integer value) {
        return super.withOperator(">>=").withValue(Integer.toString(value)).build();
    }

    public PlexFilter isLessThan(Integer value) {
        return super.withOperator("<<=").withValue(Integer.toString(value)).build();
    }
}
    
   