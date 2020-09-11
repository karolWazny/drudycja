package com.drudycja.drudycjaEngine.walka;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacteristicTest {
    @Test
    public void getTestingValue_test() {
        Characteristic characteristic = new Characteristic(30, 30, 10);
        assertEquals(characteristic.getTestingValue(), 40);
    }

    @Test
    public void changeModifiers_test() {
        Characteristic characteristic = new Characteristic(30);
        assertEquals(characteristic.getTestingValue(), 30);
        characteristic.addModifier(-10);
        assertEquals(characteristic.getTestingValue(), 20);
        characteristic.addModifier(20);
        assertEquals(characteristic.getTestingValue(), 40);
    }
}
