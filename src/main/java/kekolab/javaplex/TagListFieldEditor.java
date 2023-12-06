package kekolab.javaplex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

public class TagListFieldEditor extends FieldEditor<List<PlexTag>> {

    protected TagListFieldEditor(String queryParameterKey, Supplier<List<PlexTag>> originalValueSupplier) {
        super(queryParameterKey, originalValueSupplier, true);
    }

    @Override
    protected List<NameValuePair> queryParameters() {
        if (!isValueSet())
            return Collections.emptyList();

        List<NameValuePair> queryParameters = new ArrayList<>();
        List<PlexTag> value = getValue();
        List<PlexTag> original = getOriginalValue();
        List<PlexTag> removed = null;
        if (value == null)
            value = new ArrayList<>();
        if (original != null)
            removed = original.stream().filter(Predicate.not(value::contains)).collect(Collectors.toList());

        String queryParameterKey = getQueryParameterKey();
        if (removed != null && removed.size() > 0)
            queryParameters.add(new BasicNameValuePair(String.format("%s[].tag.tag-", queryParameterKey),
                    removed.stream().map(PlexTag::getTag).collect(Collectors.joining(","))));
        for (int i = 0; i < value.size(); i++)     
            queryParameters.add(new BasicNameValuePair(String.format("%s[%d].tag.tag", queryParameterKey, i),
                    value.get(i).getTag()));
        return queryParameters;
    }
}
