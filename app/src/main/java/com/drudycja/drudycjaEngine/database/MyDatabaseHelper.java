package com.drudycja.drudycjaEngine.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.drudycja.drudycjaEngine.ui.partycharacter.character.CharacterItem;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;
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
                POSTACIE_IMIE + " TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + POSTACIE_TABELA);
        onCreate(sqLiteDatabase);
    }

    public List<CharacterItem> getPCList() {
        List<CharacterItem> characterItemList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + POSTACIE_TABELA, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                characterItemList.add(new CharacterItem(id, name, null, null));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return characterItemList;
    }
}
