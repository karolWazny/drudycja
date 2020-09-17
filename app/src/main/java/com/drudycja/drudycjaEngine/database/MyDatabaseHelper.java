package com.drudycja.drudycjaEngine.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.drudycja.drudycjaEngine.database.character.CharacterDatabaseHandler;
import com.drudycja.drudycjaEngine.database.character.CharacterItem;
import com.drudycja.drudycjaEngine.database.party.PartyDatabaseHandler;
import com.drudycja.drudycjaEngine.database.party.PartyItem;
import com.drudycja.drudycjaEngine.ui.party.partycharacter.CharacterCreator;
import com.drudycja.drudycjaEngine.ui.party.partyparty.PartyCreator;

import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.drudycja.drudycjaEngine.database.character.PostacieKolumny.POSTACIE_TABELA;
import static com.drudycja.drudycjaEngine.database.party.PartyKolumny.PARTY_TABELA;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String NAZWA_BAZY_DANYCH = "database.db";
    private static final int WERSJA_BAZY_DANYCH = 9;

    public MyDatabaseHelper(Context kontekst) {
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
        onCreate(sqLiteDatabase);
    }

    public List<CharacterItem> getPCList() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + POSTACIE_TABELA, null);
        List<CharacterItem> characterItemList = CharacterDatabaseHandler.cursorToCharacterList(cursor);
        cursor.close();
        return characterItemList;
    }

    public CharacterItem getCharacterWithId(int id) throws Exception {
        Cursor cursor = this.getReadableDatabase().query(POSTACIE_TABELA, null,
                _ID + " = " + id, null, null, null, null);
        CharacterItem character = CharacterDatabaseHandler.cursorToCharacter(cursor);
        cursor.close();
        return character;
    }

    public void deleteCharacterWithId(int characterId) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(POSTACIE_TABELA, _ID + " = " + characterId, null);
    }

    public void addCharacter(CharacterCreator.CharacterDataPackage character) {
        ContentValues characterRecord = CharacterDatabaseHandler.characterDataToContentValues(character);
        SQLiteDatabase database = getWritableDatabase();
        database.insert(POSTACIE_TABELA, null, characterRecord);
        database.close();
    }

    public List<PartyItem> getPartyList() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + PARTY_TABELA, null);
        List<PartyItem> partyItemList = PartyDatabaseHandler.cursorToPartyList(cursor);
        cursor.close();
        return partyItemList;
    }

    public void addParty(PartyCreator.PartyDataPackage party) {

    }
}
