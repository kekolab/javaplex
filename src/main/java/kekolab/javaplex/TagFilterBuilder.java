package kekolab.javaplex;

import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexFilteringTag;

public class TagFilterBuilder extends PlexFilterBuilder {

    protected TagFilterBuilder(String field) {
        super(field);
    }

    public PlexFilter is(PlexFilteringTag tag) {
        return super.withOperator("=").withValue(tag.getKey()).build();
    }

    public PlexFilter isNot(PlexFilteringTag tag) {
        return super.withOperator("!=").withValue(tag.getKey()).build();
    }
}
    
   