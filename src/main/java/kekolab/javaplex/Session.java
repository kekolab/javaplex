package kekolab.javaplex;

import kekolab.javaplex.model.PlexSession;

public class Session extends BaseItem implements PlexSession {
    private String id;
    private Long bandwidth;
    private String location;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    @Override
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
}
