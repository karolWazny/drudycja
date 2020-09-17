package com.drudycja.drudycjaEngine.database.character;

import android.net.Uri;

import com.drudycja.drudycjaEngine.database.DatabaseConsts;

public interface PostacieKolumny extends DatabaseConsts {
    String POSTACIE_TABELA = "postacie";
    String POSTACIE_IMIE = "imie";
    String POSTACIE_RASA = "rasa";
    String POSTACIE_PROFESJA = "profesja";
    String POSTACIE_CHARAKTERYSTYKI_POCZATKOWE = "charakterystykiPoczatkowe";
    String POSTACIE_CHARAKTERYSTYKI_AKTUALNE = "charakterystykiAktualne";
    String POSTACIE_CHARAKTERYSTYKI_CHWILOWE = "charakterystykiChwilowe";
    String POSTACIE_PARTY = "partyId";
    Uri URI_TABELI_TRESC = Uri.parse(URI_OGOLNE + POSTACIE_TABELA);
}
