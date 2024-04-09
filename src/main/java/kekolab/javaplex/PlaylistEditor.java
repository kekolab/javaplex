package kekolab.javaplex;

import java.net.URI;
import java.util.Optional;

import kekolab.javaplex.model.PlexPlaylistEditor;

public class PlaylistEditor extends MetadataEditor implements PlexPlaylistEditor {
    private final FieldEditor<String> titleEditor;
    private final FieldEditor<String> summaryEditor;

    protected PlaylistEditor(Playlist source, URI editUri) {
        super(source, editUri);

        titleEditor = new StringFieldEditor("title", source::getTitle, false);
        summaryEditor = new StringFieldEditor("summary", source::getSummary, true);

        addFieldEditor(titleEditor);
        addFieldEditor(summaryEditor);
    }

    public void setTitle(String value) {
        titleEditor.setValue(value);
    }

    public void setSummary(Optional<String> value) {
        summaryEditor.setValue(value.orElse(null));
    }

}
