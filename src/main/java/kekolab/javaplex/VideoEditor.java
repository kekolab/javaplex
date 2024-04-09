package kekolab.javaplex;

import java.util.Optional;

import kekolab.javaplex.model.PlexVideoEditor;

public class VideoEditor extends SectionItemEditor implements PlexVideoEditor {
    private FieldEditor<String> contentRatingEditor;
    private FieldEditor<Boolean> contentRatingLockEditor;

    protected VideoEditor(Video source) {
        super(source);

        contentRatingEditor = new StringFieldEditor("contentRating.value", source::getContentRating, true);
        contentRatingLockEditor = new BooleanFieldEditor("contentRating.locked", source::getContentRatingLocked);

        addFieldEditor(contentRatingEditor);
        addFieldEditor(contentRatingLockEditor);
    }

    public void setContentRating(Optional<String> value, Optional<Boolean> lock) {
        editField(contentRatingEditor, value.orElse(null), contentRatingLockEditor, lock);
    }

}
