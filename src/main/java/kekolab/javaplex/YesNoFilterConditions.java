package kekolab.javaplex;

import kekolab.javaplex.model.PlexCondition;
import kekolab.javaplex.model.PlexFilter;

public class YesNoFilterConditions extends YesOnlyFilterConditions {

    protected YesNoFilterConditions(String field) {
        super(field);
    }

    public PlexCondition isNot(PlexFilter tag) {
        return super.withOperator("!=").withValue(tag.getKey()).build();
    }
}
    
   