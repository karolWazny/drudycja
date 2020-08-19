package com.drudycja.drudycjaEngine.walka;

import com.drudycja.drudycjaEngine.general.Dice;
import com.drudycja.drudycjaEngine.general.Postac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Krytyki {
    static public void trafienieKrytyczne(Postac ofiara, int wartoscKrytyczna, int wartoscTrafienia)
    {
        String nazwaPliku = new String();
        int lokacjaTrafienia = wartoscTrafienia / 10 + 10 * (wartoscTrafienia - 10*(int)(wartoscTrafienia/10));//okreslenie lokacji trafienia
        if(isInRange(lokacjaTrafienia, 1, 15))
        {
            nazwaPliku = "glowa.txt";
        } else if(isInRange(lokacjaTrafienia, 16, 55))
        {
            nazwaPliku = "reka.txt";
        } else if(isInRange(lokacjaTrafienia, 56, 80))
        {
            nazwaPliku = "korpus.txt";
        } else 
        {
            nazwaPliku = "noga.txt";
        }
        //wyznaczenie efektu trafienia krytycznego, implementacja tabeli 6-3 z podrecznika
        int efektCiosu = wartoscKrytyczna + (int)(((double)(Dice.d10()))/2+0.5) - 1;
        if(efektCiosu > 10)
        {
            efektCiosu = 10;
        }
        try 
        {
            File tabelaEfektow = new File(nazwaPliku);
            Scanner skaner = new Scanner(tabelaEfektow);
            for(int i = 1 ; i < efektCiosu ; i++)
            {
                skaner.nextLine();
            }
            //wydruk tresci efektu z pliku, tymczasowo na konsole
            System.out.println(skaner.nextLine());
            skaner.close();
        }  
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
    }

    private static boolean isInRange( int x, int lowerBorder, int upperBorder) 
    {
        return ((x>=lowerBorder)&&(x<=upperBorder));
    }
}