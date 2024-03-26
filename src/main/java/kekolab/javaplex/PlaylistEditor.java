package kekolab.javaplex;

import java.net.URI;
import java.util.Optional;

import kekolab.javaplex.model.PlexPlaylistEditor;

class PlaylistEditor extends MetadataEditor implements PlexPlaylistEditor {
    private final FieldEditor<String> titleEditor;
    private final FieldEditor<String> summaryEditor;

    PlaylistEditor(Playlist<?> source, URI editUri) {
        super(source, editUri);

        titleEditor = new StringFieldEditor("title", source::getTitle, false);        
        summaryEditor = new StringFieldEditor("summary", source::getSummary, true);

        addFieldEditor(titleEditor);
        addFieldEditor(summaryEditor);        
    }

    @Override
    public void setTitle(String value) {
        titleEditor.setValue(value);
    }

    @Override
    public void setSummary(Optional<String> value) {
        summaryEditor.setValue(value.orElse(null));
    }

}
