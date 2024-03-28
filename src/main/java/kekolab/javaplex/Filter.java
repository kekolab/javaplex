package kekolab.javaplex;

import kekolab.javaplex.model.PlexFilter;

public class Filter implements PlexFilter {
    private String field;
    private String operator;
    private String value;

    protected Filter(String field, String operator, String value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public String getQueryString() {
        return field.concat(operator.substring(0, operator.length() - 1)).concat("=").concat(value);
    }
}
