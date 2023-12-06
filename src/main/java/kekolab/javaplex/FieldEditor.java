package kekolab.javaplex;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import org.apache.hc.core5.http.NameValuePair;

public abstract class FieldEditor<T> {
    private String queryParameterKey;
    private T value;
    private boolean nullable;
    private Supplier<T> originalSupplier;
    private boolean valueSet;

    protected FieldEditor(String queryParameterKey, Supplier<T> originalValueSupplier, boolean nullable) {
        this.queryParameterKey = queryParameterKey;
        this.originalSupplier = originalValueSupplier;
        this.nullable = nullable;
        this.valueSet = false;
    }

    protected T getValue() {
        return value;
    }

    protected T getOriginalValue() {
        return originalSupplier.get();
    }

    protected String getQueryParameterKey() {
        return queryParameterKey;
    }

    protected boolean isValueSet() {
        return valueSet;
    }

    protected boolean isNullable() {
        return nullable;
    }

    protected void setValue(T value) {
        if (!nullable) {
            Objects.requireNonNull(value, "value cannot be null");
            if (value instanceof String && ((String) value).isBlank())
                throw new PlexException("value cannot be a blank String");
        }
        this.value = value;
        this.valueSet = true;
    }

    protected abstract List<NameValuePair> queryParameters();
}
