package com.drudycja.drudycjaEngine.database.party;

import android.content.ContentValues;
import android.database.Cursor;

import com.drudycja.drudycjaEngine.database.AbstractDatabaseHandler;
import com.drudycja.drudycjaEngine.ui.party.partyparty.PartyCreator;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.drudycja.drudycjaEngine.database.party.PartyKolumny.PARTY_NAZWA;
import static com.drudycja.drudycjaEngine.database.party.PartyKolumny.PARTY_TABELA;
import static com.drudycja.drudycjaEngine.database.party.PartyKolumny.PARTY_UWAGI;

public class PartyDatabaseHandler extends AbstractDatabaseHandler {

    public PartyDatabaseHandler() {
        super(columns(), PARTY_TABELA);
    }

    private static ColumnCode[] columns() {
        ColumnCode[] kolumny = new ColumnCode[3];
        kolumny[0] = new ColumnCode(_ID, "INTEGER PRIMARY KEY AUTOINCREMENT");
        kolumny[1] = new ColumnCode(PARTY_NAZWA, "BLOB NOT NULL");
        kolumny[2] = new ColumnCode(PARTY_UWAGI, "BLOB");
        return kolumny;
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
        byte[] buffer = initialisedCursor.getBlob(1);
        String name = new String(buffer);
        return new PartyItem(id, name);
    }


    public static ContentValues partyDataToContentValues(PartyCreator.PartyDataPackage partyDataPackage) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PARTY_NAZWA, partyDataPackage.name.getBytes());
        contentValues.put(PARTY_UWAGI, partyDataPackage.uwagi.getBytes());
        return contentValues;
    }
}
