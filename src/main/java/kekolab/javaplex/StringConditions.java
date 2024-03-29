package kekolab.javaplex;

import kekolab.javaplex.model.PlexCondition;

class StringConditions extends Conditions {

    protected StringConditions(String field) {
        super(field);
    }

    public PlexCondition is(String value) {
        return super.withOperator("==").withValue(value).build();
    }

    public PlexCondition isNot(String value) {
        return super.withOperator("!==").withValue(value).build();
    }
    
    public PlexCondition contains(String value) {
        return super.withOperator("=").withValue(value).build();
    }
    
    public PlexCondition doesNotContain(String value) {
        return super.withOperator("!=").withValue(value).build();
    }

    public PlexCondition beginsWith(String value) {
        return super.withOperator("<=").withValue(value).build();
    }
    
    public PlexCondition endsWith(String value) {
        return super.withOperator(">=").withValue(value).build();
    }
}