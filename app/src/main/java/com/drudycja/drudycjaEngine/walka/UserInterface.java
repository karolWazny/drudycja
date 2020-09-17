package com.drudycja.drudycjaEngine.walka;

public interface UserInterface {
    int requestRollInput();

    boolean requestConfirmation(RollHandler.RollResult result);

    void displayRollResult(RollHandler.RollResult result);
}
