package com.drudycja.drudycjaEngine.walka;

public class Tester {
    private CharacterInBattle character;
    private UserInterface userInterface;
    private boolean autoResolveOn;

    public Tester(CharacterInBattle character) {
        this.character = character;
    }

    public TestResult test(Characteristic.CharacteristicName characteristicName) {
        TestResult result = new TestResult();
        result.performer = character;
        result.testedCharacteristic = characteristicName;
        result.testedValue = character.getTestingValue(characteristicName);
        result.rollValue = obtainRollValue();
        result.isSuccessful = !(result.rollValue > result.testedValue);
        result.successLevels = (result.testedValue - result.rollValue) / 10;
        // todo implementacja punktów szczęścia
        return result;
    }

    private int obtainRollValue() {
        if (autoResolveOn) {
            return Dice.rollD100();
        } else {
            return userInterface.requestRollInput();
        }
    }

    public static class TestResult {
        public CharacterInBattle performer;
        public int rollValue;
        public int testedValue;
        public Characteristic.CharacteristicName testedCharacteristic;
        public int successLevels;
        public boolean isSuccessful;
    }
}
