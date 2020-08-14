package com.drudycja.drudycjaEngine.general;

public enum Pancerz{
    BRAK(0),
    LEKKI(1),
    SREDNI(3),
    CIEZKI(5);

    public final int wartosc;
    Pancerz(int wartosc){
        this.wartosc = wartosc;
    }
}