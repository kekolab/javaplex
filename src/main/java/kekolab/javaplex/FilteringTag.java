package kekolab.javaplex;

import java.net.URI;

import kekolab.javaplex.model.PlexFilteringTag;

class FilteringTag extends Directory implements PlexFilteringTag {
    private UriProvider fastKey;
    private String type;

    public FilteringTag() {
        fastKey = new UriProvider(this::uri);
    }

    @Override
    public String getFastKey() {
        return (String) fastKey.getValue();
    }

    @Override
    public URI fastKey() {
        return fastKey.uri();
    }

    @Override
    public String getType() {
        return type;
    }

    public void setFastKey(String fastKey) {
        this.fastKey.setValue(fastKey);
    }

    public void setType(String type) {
        this.type = type;
    }    
  }
