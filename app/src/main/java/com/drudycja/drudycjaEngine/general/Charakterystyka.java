package com.drudycja.drudycjaEngine.general;

public class Charakterystyka {
    private final int poczatkowa;
    private int aktualna;
    private int chwilowa;

    public Charakterystyka(int wartosc) {
        poczatkowa = wartosc;
        aktualna = wartosc;
        chwilowa = wartosc;
    }

    public int getPoczatkowa() {
        return poczatkowa;
    }

    public int getAktualna() {
        return aktualna;
    }

    public void setAktualna(int wartosc) {
        aktualna = wartosc;
    }

    public int getChwilowa() {
        return chwilowa;
    }

    public void setChwilowa(int wartosc) {
        chwilowa = wartosc;
    }
}