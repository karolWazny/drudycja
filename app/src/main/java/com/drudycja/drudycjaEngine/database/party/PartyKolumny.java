package com.drudycja.drudycjaEngine.database.party;

import android.net.Uri;

import com.drudycja.drudycjaEngine.database.DatabaseConsts;

public interface PartyKolumny extends DatabaseConsts {
    String PARTY_TABELA = "party";
    String PARTY_NAZWA = "nazwa";
    String PARTY_UWAGI = "uwagi";
    Uri URI_TABELI_TRESC = Uri.parse(URI_OGOLNE + PARTY_TABELA);
}
