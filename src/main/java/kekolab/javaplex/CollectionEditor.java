package kekolab.javaplex;

import java.util.Optional;

import kekolab.javaplex.model.PlexCollectionEditor;

class CollectionEditor extends SectionItemEditor implements PlexCollectionEditor {    	
	private FieldEditor<String> contentRatingEditor;	
	private FieldEditor<Boolean> contentRatingLockEditor;

    CollectionEditor(Collection<?, ?> source) {
        super(source);

        contentRatingEditor = new StringFieldEditor("contentRating.value", source::getContentRating, true);
		contentRatingLockEditor = new BooleanFieldEditor("contentRating.locked", source::getContentRatingLocked);

        addFieldEditor(contentRatingEditor);
        addFieldEditor(contentRatingLockEditor);
    }

    @Override
    public void setContentRating(Optional<String> value, Optional<Boolean> lock) {
        editField(contentRatingEditor, value.orElse(null), contentRatingLockEditor, lock);
    }    
}
