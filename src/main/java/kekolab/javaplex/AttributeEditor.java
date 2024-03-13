package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URIBuilder;

class AttributeEditor {
    private Metadata source;
    private URI editUri;
    private Supplier<List<FieldEditor<?>>> fieldEditors;

    AttributeEditor(Playlist<?> source) {
        this(source, source.editUri(), source::fieldEditors);
    }

    AttributeEditor(SectionItem<?> source) {
        this(source, source.editUri(), source::fieldEditors);
    }

    private AttributeEditor(Metadata source, URI editUri, Supplier<List<FieldEditor<?>>> fieldEditors) {
        this.source = source;
        this.editUri = editUri;
        this.fieldEditors = fieldEditors;
    }

    private static <A> List<A> joinLists(List<? extends A> l1, List<? extends A> l2) {
        List<A> joined = new ArrayList<>(l1);
        joined.addAll(l2);
        return joined;
    }

    void commit() {
        List<NameValuePair> queryParameters = fieldEditors.get().stream().map(FieldEditor::queryParameters)
                .reduce(new ArrayList<>(), AttributeEditor::joinLists);
        if (queryParameters.size() > 0) {
            URIBuilder uri = new URIBuilder(this.editUri);
            uri.addParameters(queryParameters);
            try {
                source.getClient().put(uri.build(), source.getToken(), Optional.empty());
                source.ensureDetailed(null);
            } catch (URISyntaxException e) {
                throw new PlexException("Unknown error. See attached stacktrace", e);
            }
        }
    }
}
