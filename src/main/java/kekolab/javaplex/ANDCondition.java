package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexCondition;

class ANDCondition extends CompositeCondition {

    protected ANDCondition(List<PlexCondition> filters) {
        super(filters);
    }

    @Override
    public String getConditionQuery() {        
        return getConditions().stream().map(PlexCondition::getConditionQuery).reduce((t, u) -> t.concat("&").concat(u))
                .map(q -> "push=1&" + q + "&pop=1").orElseThrow(() -> new PlexException("No conditions supplied"));
    }
}