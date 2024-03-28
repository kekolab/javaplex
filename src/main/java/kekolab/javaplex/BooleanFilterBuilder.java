package kekolab.javaplex;

import kekolab.javaplex.model.PlexFilter;

public class BooleanFilterBuilder extends PlexFilterBuilder {
    BooleanFilterBuilder(String field) {
        super(field);
    }

    public PlexFilter isTrue() {
        return super.withOperator("=").withValue(Integer.toString(1)).build();
    }

    public PlexFilter isFalse() {
        return super.withOperator("!=").withValue(Integer.toString(1)).build();
    }
}
    
   