package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

public class AttributeEditor {
    private PlexMetadata source;
    private URI editUri;
    private Supplier<List<FieldEditor<?>>> fieldEditors;

    protected AttributeEditor(PlexPlaylist<?> source) {
        this(source, source.editUri(), source::fieldEditors);
    }

    protected AttributeEditor(PlexSectionItem<?> source) {
        this(source, source.editUri(), source::fieldEditors);
    }

    private AttributeEditor(PlexMetadata source, URI editUri, Supplier<List<FieldEditor<?>>> fieldEditors) {
        this.source = source;
        this.editUri = editUri;
        this.fieldEditors = fieldEditors;
    }

    private static <A> List<A> joinLists(List<? extends A> l1, List<? extends A> l2) {
        List<A> joined = new ArrayList<>(l1);
        joined.addAll(l2);
        return joined;
    }

    protected void commit() {
        List<NameValuePair> queryParameters = fieldEditors.get().stream().map(FieldEditor::queryParameters).reduce(new ArrayList<>(), AttributeEditor::joinLists);
        if (queryParameters.size() > 0) {
            URIBuilder uri = new URIBuilder(this.editUri);
            uri.addParameters(queryParameters);
            ClassicHttpRequest req;
            try {
                req = ClassicRequestBuilder.put(uri.build()).build();
            } catch (URISyntaxException e) {
                throw new PlexException(e);
            }
            source.getClient().execute(req, source.getToken());
            source.fetchDetailedIfNullOrEmpty(null);
        }
    }
}
