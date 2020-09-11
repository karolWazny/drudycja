package com.drudycja.drudycjaEngine.walka;

public enum StandardAction { //todo lepsza nazwa
    SILNGLE_ATTACK(1, 0),
    MULTIPLE_ATTACK(2, 1),
    SKIP_ROUND(0, 2);

    public final int lengthInRounds;
    public final int actionId;

    StandardAction(int lengthInRounds, int actionId) {
        this.lengthInRounds = lengthInRounds;
        this.actionId = actionId;
    }
}
