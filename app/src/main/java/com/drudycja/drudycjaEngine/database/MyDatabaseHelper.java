package com.drudycja.drudycjaEngine.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.drudycja.drudycjaEngine.ui.party.partycharacter.character.CharacterItem;

import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_TABELA;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String NAZWA_BAZY_DANYCH = "database.db";
    private static final int WERSJA_BAZY_DANYCH = 8;

    public MyDatabaseHelper(Context kontekst) {
        super(kontekst, NAZWA_BAZY_DANYCH, null, WERSJA_BAZY_DANYCH);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(new CharacterDatabaseHelper().generateSqlCreateTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + POSTACIE_TABELA);
        onCreate(sqLiteDatabase);
    }

    public List<CharacterItem> getPCList() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + POSTACIE_TABELA, null);
        List<CharacterItem> characterItemList = CharacterDatabaseHelper.cursorToCharacterList(cursor);
        cursor.close();
        return characterItemList;
    }

    public CharacterItem getCharacterWithId(int id) throws Exception {
        Cursor cursor = this.getReadableDatabase().query(POSTACIE_TABELA, null,
                _ID + " = " + id, null, null, null, null);
        CharacterItem character = CharacterDatabaseHelper.cursorToCharacter(cursor);
        cursor.close();
        return character;
    }

    public void deleteCharacterWithId(int characterId) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(POSTACIE_TABELA, _ID + " = " + characterId, null);
    }
}
