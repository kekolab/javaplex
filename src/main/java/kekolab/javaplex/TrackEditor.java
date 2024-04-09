package kekolab.javaplex;

import java.util.List;
import java.util.Optional;

import kekolab.javaplex.model.PlexTrackEditor;

public class TrackEditor extends SectionItemEditor implements PlexTrackEditor {
	private FieldEditor<List<String>> moodEditor;
	private FieldEditor<Boolean> moodLockEditor;

    protected TrackEditor(Track source) {
        super(source);
        
        moodEditor = new TagListFieldEditor("mood", source::getMoods);
		moodLockEditor = new BooleanFieldEditor("mood.locked", source::getMoodsLocked);

        addFieldEditor(moodEditor);
        addFieldEditor(moodLockEditor);
    }

    public void setMoods(List<String> values, Optional<Boolean> lock) {
        editField(moodEditor, values, moodLockEditor, lock);
    } 
    
}
