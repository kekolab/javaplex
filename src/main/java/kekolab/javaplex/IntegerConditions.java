package kekolab.javaplex;

import kekolab.javaplex.model.PlexCondition;

public class IntegerConditions extends Conditions {

    protected IntegerConditions(String field) {
        super(field);
    }

    public PlexCondition is(Integer value) {
        return super.withOperator("=").withValue(Integer.toString(value)).build();
    }

    public PlexCondition isNot(Integer value) {
        return super.withOperator("!=").withValue(Integer.toString(value)).build();
    }

    public PlexCondition isGreaterThan(Integer value) {
        return super.withOperator(">>=").withValue(Integer.toString(value)).build();
    }

    public PlexCondition isLessThan(Integer value) {
        return super.withOperator("<<=").withValue(Integer.toString(value)).build();
    }
}
    
   