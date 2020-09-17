package com.drudycja.drudycjaEngine.walka;

import java.util.Random;

public class Dice {
    private static Random random = new Random();

    public static int rollD100() {
        return random.nextInt(100) + 1;
    }
}
