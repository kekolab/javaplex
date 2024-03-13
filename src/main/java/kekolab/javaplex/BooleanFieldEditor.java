package kekolab.javaplex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

class BooleanFieldEditor extends FieldEditor<Boolean> {
    BooleanFieldEditor(String queryParameterKey, Supplier<Boolean> originalValueSupplier) {
        super(queryParameterKey, originalValueSupplier, false);
    }

    @Override
    List<NameValuePair> queryParameters() {
        if (!isValueSet())
            return Collections.emptyList();

        Boolean value = getValue();
        Boolean original = getOriginalValue();
        if (value && (original == null || !original))
            return Arrays.asList(new BasicNameValuePair(getQueryParameterKey(), "1"));
        else if (!value && original != null && original)
            return Arrays.asList(new BasicNameValuePair(getQueryParameterKey(), "0"));
        return Collections.emptyList();
    }
}