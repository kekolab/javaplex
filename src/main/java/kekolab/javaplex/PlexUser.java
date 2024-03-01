package kekolab.javaplex;

import java.net.URI;

public class PlexUser extends BaseItem {
    private String id;
    private String title;

    private UriProvider thumb;

    public PlexUser() {
        thumb = new UriProvider(null);
    }

    @Override
	protected void clear() {
		super.clear();
        id = null;
        thumb.setValue(null);
        title = null;        
	}

	@Override
	protected void update(BaseItem source) {
	super.update(source);
		if (source instanceof PlexUser user) {
            id = user.id;
            thumb.setValue(user.thumb.getValue());
            title = user.title;
		} else
			throw new ClassCastException("Cannot cast item to PlexUser");
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumb(String thumb) {
        this.thumb.setValue(thumb);
    }

    public String getThumb() {
        return (String) thumb.getValue();
    }

    public URI thumb() {
        return thumb.uri();
    }

}
