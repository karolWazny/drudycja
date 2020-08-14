package com.drudycja.drudycjaEngine.database;

import android.net.Uri;

public interface PartyKolumny extends DatabaseConsts {
    public final static String PARTY_TABELA = "party";
    public final static String PARTY_NAZWA = "nazwa";
    public final static Uri URI_TABELI_TRESC = Uri.parse(URI_OGOLNE+PARTY_TABELA);
}
