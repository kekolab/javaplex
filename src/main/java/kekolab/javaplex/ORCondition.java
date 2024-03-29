package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexCondition;

class ORCondition extends CompositeCondition {
    protected ORCondition(List<PlexCondition> conditions) {
        super(conditions);
    }

    @Override
    public String getConditionQuery() {
        return getConditions().stream().map(PlexCondition::getConditionQuery)
                .reduce((t, u) -> t.concat("&or=1&").concat(u)).map(q -> "push=1&" + q + "&pop=1").get();
    }
}