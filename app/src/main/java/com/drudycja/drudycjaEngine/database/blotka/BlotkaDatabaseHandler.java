package com.drudycja.drudycjaEngine.database.blotka;

import android.database.Cursor;
import android.provider.BaseColumns;

import com.drudycja.drudycjaEngine.database.AbstractDatabaseHandler;
import com.drudycja.drudycjaEngine.database.Item;

import java.util.LinkedList;
import java.util.List;

import static com.drudycja.drudycjaEngine.database.blotka.BlotkiKolumny.BLOTKI_CHARAKTERYSTYKI;
import static com.drudycja.drudycjaEngine.database.blotka.BlotkiKolumny.BLOTKI_NAZWA;
import static com.drudycja.drudycjaEngine.database.blotka.BlotkiKolumny.BLOTKI_TABELA;

public class BlotkaDatabaseHandler extends AbstractDatabaseHandler {
    public BlotkaDatabaseHandler() {
        super(columns(), BLOTKI_TABELA);
    }

    private static ColumnCode[] columns() {
        ColumnCode[] kolumny = new ColumnCode[3];
        kolumny[0] = new ColumnCode(BaseColumns._ID, "INTEGER PRIMARY KEY AUTOINCREMENT");
        kolumny[1] = new ColumnCode(BLOTKI_NAZWA, "TEXT NOT NULL");
        kolumny[2] = new ColumnCode(BLOTKI_CHARAKTERYSTYKI, "BLOB");
        return kolumny;
    }

    public static Item cursorToItem(Cursor cursor) throws Exception {
        if (!cursor.moveToFirst()) {
            throw new Exception();
        }
        return cursorRecordToItem(cursor);
    }

    private static Item cursorRecordToItem(Cursor cursor) {
        Item item = new Item();
        item.id = cursor.getInt(0);
        item.name = new String(cursor.getBlob(1));
        return item;
    }

    public static List<Item> cursorToItemList(Cursor cursor) {
        List<Item> items = new LinkedList<>();
        if (cursor.moveToFirst()) {
            do {
                items.add(cursorRecordToItem(cursor));
            } while (cursor.moveToNext());
        }
        return items;
    }
}
