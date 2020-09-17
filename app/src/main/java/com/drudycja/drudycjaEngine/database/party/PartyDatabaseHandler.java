package com.drudycja.drudycjaEngine.database.party;

import android.database.Cursor;

import com.drudycja.drudycjaEngine.database.AbstractDatabaseHandler;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.drudycja.drudycjaEngine.database.party.PartyKolumny.PARTY_NAZWA;
import static com.drudycja.drudycjaEngine.database.party.PartyKolumny.PARTY_TABELA;

public class PartyDatabaseHandler extends AbstractDatabaseHandler {
    private ColumnCode[] kolumny;

    public PartyDatabaseHandler() {
        kolumny = new ColumnCode[2];
        kolumny[0] = new ColumnCode(_ID, "INTEGER PRIMARY KEY AUTOINCREMENT");
        kolumny[1] = new ColumnCode(PARTY_NAZWA, "BLOB NOT NULL");
    }

    public static List<PartyItem> cursorToPartyList(Cursor cursor) {
        List<PartyItem> parties = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                parties.add(cursorRecordToParty(cursor));
            } while (cursor.moveToNext());
        }
        return parties;
    }

    private static PartyItem cursorRecordToParty(Cursor initialisedCursor) {
        int id = initialisedCursor.getInt(0);
        String name = initialisedCursor.getString(1);
        return new PartyItem(id, name);
    }

    public String generateSqlCreateTable() {
        StringBuilder builder = new StringBuilder("CREATE TABLE ");
        builder.append(PARTY_TABELA)
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
