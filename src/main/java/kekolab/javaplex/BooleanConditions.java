package kekolab.javaplex;

import kekolab.javaplex.model.PlexCondition;

public class BooleanConditions extends Conditions {
    BooleanConditions(String field) {
        super(field);
    }

    public PlexCondition isTrue() {
        return super.withOperator("=").withValue(Integer.toString(1)).build();
    }

    public PlexCondition isFalse() {
        return super.withOperator("!=").withValue(Integer.toString(1)).build();
    }
}
    
   