package com.drudycja.drudycjaEngine.database;

import android.net.Uri;

public interface PostacieKolumny extends DatabaseConsts {
    public static final String POSTACIE_TABELA = "postacie";
    public static final String POSTACIE_IMIE = "imie";
    public static final String POSTACIE_CHARAKTERYSTYKI_POCZATKOWE = "charakterystykiPoczatkowe";
    public static final String POSTACIE_CHARAKTERYSTYKI_AKTUALNE = "charakterystykiAktualne";
    public static final String POSTACIE_CHARAKTERYSTYKI_CHWILOWE = "charakterystykiChwilowe";
    public static final String POSTACIE_PARTY = "partyId";
    public static final Uri URI_TABELI_TRESC = Uri.parse(URI_OGOLNE+POSTACIE_TABELA);
}
