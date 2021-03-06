package com.drudycja.drudycjaEngine.walka;

public class Executors {
    public static class SingleAttackExecutor implements ActionExecutor {
        @Override
        public void execute(Action action) {
            CharacterInBattle performer = action.getPerformer();
            CharacterInBattle target = action.getTarget();
            performer.attack(target);
        }
    }

    public static class MultipleAttackExecutor implements ActionExecutor {
        @Override
        public void execute(Action action) {

        }
    }

    public static class SkipRoundExecutor implements ActionExecutor {
        @Override
        public void execute(Action action) {

        }
    }
}
