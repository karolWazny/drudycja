package com.drudycja.drudycjaEngine.general;

public class Postac {
    public static final int BEZBRONNY = -3;
    public static final int OGLUSZONY = -1;
    public static final int PRZYTOMNY = -2;

    private Charakterystyka walkaWrecz;
    private Charakterystyka umiejetnosciStrzeleckie;
    private Charakterystyka krzepa;
    private Charakterystyka odpornosc;
    private Charakterystyka zrecznosc;
    private Charakterystyka intelekt;
    private Charakterystyka silaWoli;
    private Charakterystyka oglada;
    private Charakterystyka ataki;
    private Charakterystyka zywotnosc;
    private Charakterystyka sila;
    private Charakterystyka wytrzymalosc;
    private Charakterystyka szybkosc;
    private Charakterystyka magia;
    private Charakterystyka punktyObledu;
    private Charakterystyka punktyPrzeznaczenia;
    private Charakterystyka punktySzczescia;
    private Charakterystyka[] characteristics;
    private Boolean jestZywy = true;
    private Pancerz pancerz;
    private int przytomnosc;

    public int getWalkaWrecz() {
        return characteristics[0].getChwilowa();
    }

    public int umiejetnosciStrzeleckie() {
        return characteristics[1].getChwilowa();
    }
   
   public int getKrzepa() {
       return characteristics[2].getChwilowa();
   }

   public int getOdpornosc() {
       return characteristics[3].getChwilowa();
    }

    public int getZrecznosc() {
        return characteristics[4].getChwilowa();
    }

    public int getIntelekt() {
        return characteristics[5].getChwilowa();
    }

    public int getSilaWoli() {
        return characteristics[6].getChwilowa();
    }

    public int getOglada() {
        return characteristics[7].getChwilowa();
    }

    public int getAtaki() {
        return characteristics[8].getChwilowa();
    }

    public int getZywotnosc() {
        return characteristics[9].getChwilowa();
    }

    public void setZywotnosc(int value) {
        zywotnosc.setChwilowa(value);
    }

    public int getSila() {
        return characteristics[10].getChwilowa();
    }

    public int getWytrzymalosc() {
        return characteristics[11].getChwilowa();
    }

    public int getSzybkosc() {
        return characteristics[12].getChwilowa();
    }

    public int getMagia() {
        return characteristics[13].getChwilowa();
    }

    public int getPunktyObledu() {
        return characteristics[14].getChwilowa();
    }

    public void setPunktyObledu(int arg) {
        punktyObledu.setAktualna(arg);
        punktyObledu.setChwilowa(arg);
    }

    public int getPunktyPrzeznaczenia() {
        return characteristics[15].getChwilowa();
    }

    public int getPunktySzczescia() {
        return punktySzczescia.getChwilowa();
    }

    public boolean getJestZywy() {
        return jestZywy;
    }

    public Pancerz getPancerz() {
        return pancerz;
    }

    public int getPrzytomnosc() {
        return przytomnosc;
    }

    public Postac(int[] charakterystyki) {
        bebechyKonstruktora(charakterystyki);
    }

    private void bebechyKonstruktora(int[] charakterystyki) {
        characteristics = new Charakterystyka[16];
        for (int i = 0; i < 16; i++) {
            characteristics[i] = new Charakterystyka(charakterystyki[i]);
        }
    }

    public Postac() {
        int[] charakterystyki = new int[16];
        for (int i = 0; i < 8; i++) {
            charakterystyki[i] = 31;
        }
        charakterystyki[8] = 1;
        charakterystyki[9] = 11;
        charakterystyki[10] = 3;
        charakterystyki[11] = 3;
        charakterystyki[12] = 4;
        charakterystyki[13] = 0;
        charakterystyki[14] = 0;
        charakterystyki[15] = 2;
        bebechyKonstruktora(charakterystyki);
        pancerz = Pancerz.BRAK;
    }

    //metody walki#####################################################################

    public void rana(int arg)
    {
    }
}
