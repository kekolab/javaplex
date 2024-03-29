package kekolab.javaplex;

import kekolab.javaplex.model.PlexCondition;
import kekolab.javaplex.model.PlexFilter;

public class YesOnlyFilterConditions extends Conditions {
    protected YesOnlyFilterConditions(String field) {
        super(field);
    }

    public PlexCondition is(PlexFilter tag) {
        return super.withOperator("=").withValue(tag.getKey()).build();
    }   

}