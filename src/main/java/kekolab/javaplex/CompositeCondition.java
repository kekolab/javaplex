package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexCondition;

abstract class CompositeCondition implements PlexCondition {
    private final List<PlexCondition> conditions;

    protected CompositeCondition(List<PlexCondition> conditions) {
        this.conditions = conditions;
    }

    protected List<PlexCondition> getConditions() {
        return conditions;
    }
}