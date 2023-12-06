package kekolab.javaplex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

public class StringFieldEditor extends FieldEditor<String> {

    protected StringFieldEditor(String queryParameterKey, Supplier<String> originalValueSupplier,
            boolean nullable) {
        super(queryParameterKey, originalValueSupplier, nullable);
    }

    @Override
    protected void setValue(String value) {
        if (!isNullable() && value != null && value.isBlank())
            throw new PlexException("value cannot be a blank String");
        super.setValue(value);
    }

    @Override
    protected List<NameValuePair> queryParameters() {
        if (!isValueSet())
            return Collections.emptyList();

        String original = getOriginalValue();
        String value = getValue();
        if (value != null && !value.equals(original))
            return Arrays.asList(new BasicNameValuePair(getQueryParameterKey(), value));
        else if (value == null && original != null)
            return Arrays.asList(new BasicNameValuePair(getQueryParameterKey(), ""));
        return Collections.emptyList();
    }

}