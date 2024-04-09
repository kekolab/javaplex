package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowCollection;
import kekolab.javaplex.model.PlexShowSection;

public class ShowCollection extends Collection implements PlexShowCollection {
    @Override
    public List<PlexShow> children() {
        return super.children().stream().map(PlexShow.class::cast).toList();
    }

    @Override
    public PlexShowSection section() {
        return (PlexShowSection) super.section();
    }
}
