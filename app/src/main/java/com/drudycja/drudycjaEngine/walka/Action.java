package com.drudycja.drudycjaEngine.walka;

public class Action {
    private final CharacterInBattle performer;
    private final CharacterInBattle target;
    private final StandardAction standardAction;
    private final ActionExecutor actionExecutor;

    private Action(ActionBuilder actionBuilder) {
        this.standardAction = actionBuilder.standardAction;
        this.actionExecutor = actionBuilder.actionExecutor;
        this.performer = actionBuilder.performer;
        this.target = actionBuilder.target;
    }

    public void execute() {
        actionExecutor.execute(this);
    }

    public static class ActionBuilder {
        private CharacterInBattle performer;
        private CharacterInBattle target;
        private StandardAction standardAction;
        private ActionExecutor actionExecutor;

        public ActionBuilder addPerformer(CharacterInBattle performer) {
            this.performer = performer;
            return this;
        }

        public ActionBuilder addTarget(CharacterInBattle target) {
            this.target = target;
            return this;
        }

        public ActionBuilder addStandardAction(StandardAction standardAction) {
            this.standardAction = standardAction;
            this.actionExecutor = matchActionExecutorTo(standardAction);
            return this;
        }

        private ActionExecutor matchActionExecutorTo(StandardAction standardAction) {
            switch (standardAction) {
                case SILNGLE_ATTACK:
                    return new Executors.SingleAttackExecutor();
                case MULTIPLE_ATTACK:
                    return new Executors.MultipleAttackExecutor();
                case SKIP_ROUND:
                    return new Executors.SkipRoundExecutor();
                default:
                    return null;
            }
        }

        public Action build() {
            return new Action(this);
        }
    }
}
