package com.drudycja.drudycjaEngine.walka;

public class Characteristic {
    private final int maxValue;
    private int currentValue;
    private int modifiers;

    public Characteristic(int maxValue) {
        this(maxValue, maxValue, 0);
    }

    public Characteristic(int maxValue, int currentValue, int modifiers) {
        this.maxValue = maxValue;
        this.currentValue = currentValue;
        this.modifiers = modifiers;
    }

    public int getTestingValue() {
        return currentValue + modifiers;
    }

    public void addModifier(int modifier) {
        modifiers += modifier;
    }
}
