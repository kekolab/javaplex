package kekolab.javaplex;

import kekolab.javaplex.model.PlexCondition;
import kekolab.javaplex.model.PlexFilter;

public class FilterConditions extends Conditions {

    protected FilterConditions(String field) {
        super(field);
    }

    public PlexCondition is(PlexFilter tag) {
        return super.withOperator("=").withValue(tag.getKey()).build();
    }

    public PlexCondition isNot(PlexFilter tag) {
        return super.withOperator("!=").withValue(tag.getKey()).build();
    }
}
    
   