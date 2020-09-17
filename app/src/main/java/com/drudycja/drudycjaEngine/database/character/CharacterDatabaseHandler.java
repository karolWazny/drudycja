package com.drudycja.drudycjaEngine.database.character;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.drudycja.drudycjaEngine.database.AbstractDatabaseHandler;
import com.drudycja.drudycjaEngine.ui.party.partycharacter.CharacterCreator;

import java.util.ArrayList;
import java.util.List;

public class CharacterDatabaseHandler extends AbstractDatabaseHandler implements PostacieKolumny {
    private ColumnCode[] kolumny;

    public CharacterDatabaseHandler() {
        kolumny = new ColumnCode[6];
        kolumny[0] = new ColumnCode(BaseColumns._ID, "INTEGER PRIMARY KEY AUTOINCREMENT");
        kolumny[1] = new ColumnCode(POSTACIE_IMIE, "TEXT NOT NULL");
        kolumny[2] = new ColumnCode(POSTACIE_RASA, "INTEGER NOT NULL");
        kolumny[3] = new ColumnCode(POSTACIE_PROFESJA, "TEXT NOT NULL");
        kolumny[4] = new ColumnCode(POSTACIE_CHARAKTERYSTYKI_POCZATKOWE, "BLOB");
        kolumny[5] = new ColumnCode(POSTACIE_PARTY, "INTEGER");
    }

    public static CharacterItem cursorToCharacter(Cursor cursor) throws Exception {
        if (!cursor.moveToFirst()) {
            throw new Exception();
        }
        return cursorRecordToCharacter(cursor);
    }

    public static List<CharacterItem> cursorToCharacterList(Cursor cursor) {
        List<CharacterItem> characters = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                try {
                    characters.add(cursorRecordToCharacter(cursor));
                } catch (IncorrectRaceIdException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }
        return characters;
    }

    private static CharacterItem cursorRecordToCharacter(Cursor initialisedCursor) throws IncorrectRaceIdException {
        int characterId = initialisedCursor.getInt(0);
        String name = initialisedCursor.getString(1);
        int raceId = initialisedCursor.getInt(2);
        String profession = initialisedCursor.getString(3);
        byte[] characteristic = initialisedCursor.getBlob(4);
        return new CharacterItem(characterId, name, Race.fromRaceId(raceId), profession, characteristic,
                null);
    }

    public static ContentValues characterDataToContentValues(CharacterCreator.CharacterDataPackage characterDataPackage) {
        ContentValues characterRecord = new ContentValues();
        characterRecord.put(POSTACIE_IMIE, characterDataPackage.imie);
        characterRecord.put(POSTACIE_RASA, characterDataPackage.raceId);
        characterRecord.put(POSTACIE_PROFESJA, characterDataPackage.profesja);
        characterRecord.put(POSTACIE_CHARAKTERYSTYKI_POCZATKOWE, characterDataPackage.charakterystyki);
        return characterRecord;
    }

    public String generateSqlCreateTable() {
        StringBuilder builder = new StringBuilder("CREATE TABLE ");
        builder.append(POSTACIE_TABELA)
                .append("(");
        for (int i = 0; i < kolumny.length - 1; i++) {
            builder.append(kolumny[i].generateCreateColumnSql())
                    .append(", ");
        }
        builder.append(kolumny[kolumny.length - 1].generateCreateColumnSql())
                .append(");");
        return builder.toString();
    }
}
