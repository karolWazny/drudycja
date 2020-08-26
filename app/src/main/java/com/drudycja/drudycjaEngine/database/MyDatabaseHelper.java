package com.drudycja.drudycjaEngine.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_CHARAKTERYSTYKI_POCZATKOWE;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_IMIE;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_TABELA;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String NAZWA_BAZY_DANYCH = "database.db";
    private static final int WERSJA_BAZY_DANYCH = 2;

    public MyDatabaseHelper(Context kontekst) {
        super(kontekst, NAZWA_BAZY_DANYCH, null, WERSJA_BAZY_DANYCH);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + POSTACIE_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                POSTACIE_IMIE + " TEXT NOT NULL, " +
                POSTACIE_CHARAKTERYSTYKI_POCZATKOWE + " BLOB);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + POSTACIE_TABELA);
        onCreate(sqLiteDatabase);
    }
}
