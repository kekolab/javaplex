package kekolab.javaplex;

import kekolab.javaplex.model.PlexSession;

class Session extends BaseItem implements PlexSession{
    private String id;
    private Long bandwidth;
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
}
