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

    public enum CharacteristicName {
        WALKA_WRECZ(0),
        UMIEJETNOSCI_STRZELECKIE(1),
        KRZEPA(2),
        ODPORNOSC(3),
        ZRECZNOSC(4),
        INTELIGENCJA(5),
        SILA_WOLI(6),
        OGLADA(7);

        public final int index;

        CharacteristicName(int index) {
            this.index = index;
        }
    }
}
