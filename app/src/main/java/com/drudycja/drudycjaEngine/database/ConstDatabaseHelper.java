package com.drudycja.drudycjaEngine.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.drudycja.drudycjaEngine.database.character.CharacterDatabaseHandler;
import com.drudycja.drudycjaEngine.database.party.PartyDatabaseHandler;

import static com.drudycja.drudycjaEngine.database.character.PostacieKolumny.POSTACIE_TABELA;
import static com.drudycja.drudycjaEngine.database.party.PartyKolumny.PARTY_TABELA;

public class ConstDatabaseHelper extends SQLiteOpenHelper {
    private static final String NAZWA_BAZY_DANYCH = "constdatabase.db";
    private static final int WERSJA_BAZY_DANYCH = 1;

    public ConstDatabaseHelper(Context kontekst) {
        super(kontekst, NAZWA_BAZY_DANYCH, null, WERSJA_BAZY_DANYCH);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(new CharacterDatabaseHandler().generateSqlCreateTable());
        sqLiteDatabase.execSQL(new PartyDatabaseHandler().generateSqlCreateTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + POSTACIE_TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PARTY_TABELA);
        onCreate(sqLiteDatabase);
    }
}
