package com.drudycja.drudycjaEngine.ui.partycharacter.character;

import com.drudycja.R;

import static com.drudycja.drudycjaEngine.ui.partycharacter.BazoweWartosci.CZLOWIEK_WARTOSCI_BAZOWE;
import static com.drudycja.drudycjaEngine.ui.partycharacter.BazoweWartosci.ELF_WARTOSCI_BAZOWE;
import static com.drudycja.drudycjaEngine.ui.partycharacter.BazoweWartosci.KRASNOLUD_WARTOSCI_BAZOWE;
import static com.drudycja.drudycjaEngine.ui.partycharacter.BazoweWartosci.NIZIOL_WARTOSCI_BAZOWE;

public enum Race {
    CZLOWIEK(R.string.lab_man, CZLOWIEK_WARTOSCI_BAZOWE),
    ELF(R.string.lab_elf, ELF_WARTOSCI_BAZOWE),
    KRASNOLUD(R.string.lab_dwarf, KRASNOLUD_WARTOSCI_BAZOWE),
    NIZIOL(R.string.lab_halfling, NIZIOL_WARTOSCI_BAZOWE);

    public final int raceNameId;
    public final int[] baseValues;

    Race(int raceNameId, int[] baseValues) {
        this.raceNameId = raceNameId;
        this.baseValues = baseValues;
    }
}
