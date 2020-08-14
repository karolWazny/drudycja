package com.drudycja.drudycjaEngine.general;

public class Postac {
    //stale#################################################
    public final int BEZBRONNY = -3;
    public final int OGLUSZONY = -1;
    public final int PRZYTOMNY = -2;

    //pola ################################################

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
   private Boolean jestZywy=true;
   private Pancerz pancerz;
   private int przytomnosc;

   //getter/setter###########################################
   public int getWalkaWrecz() {
       return walkaWrecz.getChwilowa();
   }

   public int umiejetnosciStrzeleckie() {
        return umiejetnosciStrzeleckie.getChwilowa();
   }
   
   public int getKrzepa() {
        return krzepa.getChwilowa();
   }

   public int getOdpornosc() {
        return odpornosc.getChwilowa();
    }

    public int getZrecznosc() {
        return zrecznosc.getChwilowa();
    }

    public int getIntelekt() {
        return intelekt.getChwilowa();
    }

    public int getSilaWoli() {
        return silaWoli.getChwilowa();
    }

    public int getOglada() {
        return oglada.getChwilowa();
    }

    public int getAtaki() {
        return ataki.getChwilowa();
    }

    public int getZywotnosc() {
        return zywotnosc.getChwilowa();
    }

    public void setZywotnosc(int value) {
        zywotnosc.setChwilowa(value);
    }

    public int getSila() {
        return sila.getChwilowa();
    }

    public int getWytrzymalosc() {
        return wytrzymalosc.getChwilowa();
    }

    public int getSzybkosc() {
        return szybkosc.getChwilowa();
    }

    public int getMagia() {
        return magia.getChwilowa();
    }

    public int getPunktyObledu() {
        return punktyObledu.getChwilowa();
    }

    public void setPunktyObledu(int arg) {
        punktyObledu.setAktualna(arg);
        punktyObledu.setChwilowa(arg);
    }

    public int getPunktyPrzeznaczenia() {
        return punktyPrzeznaczenia.getChwilowa();
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
//konstruktor#################################################################

    public Postac(int[] charakterystyki){
        bebechyKonstruktora(charakterystyki);
    }

    //konstruktor domyslny######################################################
    private void bebechyKonstruktora (int[] charakterystyki){
        walkaWrecz = new Charakterystyka(charakterystyki[0]);
        umiejetnosciStrzeleckie = new Charakterystyka(charakterystyki[1]);
        krzepa = new Charakterystyka(charakterystyki[2]);
        odpornosc = new Charakterystyka(charakterystyki[3]);
        zrecznosc = new Charakterystyka(charakterystyki[4]);
        intelekt = new Charakterystyka(charakterystyki[5]);
        silaWoli = new Charakterystyka(charakterystyki[6]);
        oglada = new Charakterystyka(charakterystyki[7]);
        ataki = new Charakterystyka(charakterystyki[8]);
        zywotnosc = new Charakterystyka(charakterystyki[9]);
        sila = new Charakterystyka(charakterystyki[10]);
        wytrzymalosc = new Charakterystyka(charakterystyki[11]);
        szybkosc = new Charakterystyka(charakterystyki[12]);
        magia = new Charakterystyka(charakterystyki[13]);
        punktyObledu = new Charakterystyka(charakterystyki[14]);
        punktyPrzeznaczenia = new Charakterystyka(charakterystyki[15]);
        punktySzczescia = new Charakterystyka(charakterystyki[15]);
        przytomnosc = 2;
    }

   public Postac()
    {
        int[] charakterystyki = new int[16];
        for(int i = 0; i < 8; i++)
        {
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

//klasa pomocnicza Charakterystyka#########################################################

