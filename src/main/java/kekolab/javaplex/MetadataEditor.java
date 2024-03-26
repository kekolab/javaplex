package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexMetadataEditor;

class MetadataEditor implements PlexMetadataEditor {
    private final Metadata source;
    private final URI editUri;
    private List<FieldEditor<?>> fieldEditors;

    void addFieldEditor(FieldEditor<?> fieldEditor) {
        fieldEditors.add(fieldEditor);
    }

    MetadataEditor(Metadata source, URI editUri) {
        this.source = source;
        this.editUri = editUri;
        fieldEditors = new ArrayList<>();
    }

    private static <A> List<A> joinLists(List<? extends A> first, List<? extends A> second) {
        List<A> joined = new ArrayList<>(first);
        joined.addAll(second);
        return joined;
    }

    @Override
    public void commit() {
        List<NameValuePair> queryParameters = fieldEditors.stream().map(FieldEditor::queryParameters)
                .reduce(new ArrayList<>(), MetadataEditor::joinLists);
        if (queryParameters.size() > 0) {
            URIBuilder uri = new URIBuilder(this.editUri);
            uri.addParameters(queryParameters);
            try {
                source.getServer().getClient().put(uri.build(), source.getServer().getToken(), Optional.empty());
                source.ensureDetailed(null);
            } catch (URISyntaxException e) {
                throw new PlexException("Unknown error. See attached stacktrace", e);
            }
        }
    }

}
