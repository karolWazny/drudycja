package com.drudycja.drudycjaEngine.walka;

public class RollHandler {
    private UserInterface userInterface;
    private boolean autoResolveOn;

    public RollResult performRoll() {
        RollResult result = new RollResult();
        result.rollValue = obtainRollValue();
        return null;
    }

    private int obtainRollValue() {
        if (autoResolveOn) {
            return Dice.rollD100();
        } else {
            return userInterface.requestRollInput();
        }
    }

    public static class RollResult {
        public int rollValue;
        public int testedValue;
        public Characteristic.CharacteristicName testedCharacteristic;
        public int successLevels;
        public boolean isSuccessful;
    }
}
