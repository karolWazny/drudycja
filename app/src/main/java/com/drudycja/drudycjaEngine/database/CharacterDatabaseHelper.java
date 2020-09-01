package com.drudycja.drudycjaEngine.database;

import android.database.Cursor;

import com.drudycja.drudycjaEngine.ui.partycharacter.character.CharacterItem;

import java.util.ArrayList;
import java.util.List;

public class CharacterDatabaseHelper extends AbstractDatabaseHandler implements PostacieKolumny {
    private ColumnCode[] kolumny;

    public CharacterDatabaseHelper() {
        kolumny = new ColumnCode[5];
        kolumny[0] = new ColumnCode(_ID, "INTEGER PRIMARY KEY AUTOINCREMENT");
        kolumny[1] = new ColumnCode(POSTACIE_IMIE, "TEXT NOT NULL");
        kolumny[2] = new ColumnCode(POSTACIE_RASA, "INTEGER NOT NULL");
        kolumny[3] = new ColumnCode(POSTACIE_PROFESJA, "TEXT NOT NULL");
        kolumny[4] = new ColumnCode(POSTACIE_CHARAKTERYSTYKI_POCZATKOWE, "BLOB");
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
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                int raceId = cursor.getInt(2);
                String profession = cursor.getString(3);
                characters.add(new CharacterItem(id, name, raceId, profession));
            } while (cursor.moveToNext());
        }
        return characters;
    }

    private static CharacterItem cursorRecordToCharacter(Cursor initialisedCursor) {
        int characterId = initialisedCursor.getInt(0);
        String name = initialisedCursor.getString(1);
        int raceId = initialisedCursor.getInt(2);
        String profession = initialisedCursor.getString(3);
        byte[] characteristic = initialisedCursor.getBlob(4);
        return new CharacterItem(characterId, name, raceId, profession, characteristic,
                null);
    }

    public String generateSqlCreateTable() {
        StringBuilder builder = new StringBuilder("CREATE TABLE ");
        builder.append(POSTACIE_TABELA)
                .append("(");
        for (int i = 0; i < 4; i++) {
            builder.append(kolumny[i].generateCreateColumnSql())
                    .append(", ");
        }
        builder.append(kolumny[4].generateCreateColumnSql())
                .append(");");
        return builder.toString();
    }
}
