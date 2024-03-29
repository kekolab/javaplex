package kekolab.javaplex;

import kekolab.javaplex.model.PlexCondition;

class Condition implements PlexCondition {
    private String field;
    private String operator;
    private String value;

    protected Condition(String field, String operator, String value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public String getConditionQuery() {
        return field.concat(operator.substring(0, operator.length() - 1)).concat("=").concat(value);
    }
}
