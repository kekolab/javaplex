package kekolab.javaplex;

public class PlexSession extends BaseItem {
    private String id;
    private Long bandwidth;
    private String location;

    @Override
    protected void clear() {
        super.clear();
        id = null;
        bandwidth = null;
        location = null;
    }

    @Override
    protected void update(BaseItem source) {
        super.update(source);
        if (source instanceof PlexSession session) {
            id = session.id;
            bandwidth = session.bandwidth;
            location = session.location;
        } else {
            throw new ClassCastException("Cannot cast item to PlexSession");
        }
    }

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
