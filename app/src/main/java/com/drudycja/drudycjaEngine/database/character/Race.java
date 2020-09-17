package com.drudycja.drudycjaEngine.database.character;

import com.drudycja.R;

import static com.drudycja.drudycjaEngine.ui.party.partycharacter.BazoweWartosci.CZLOWIEK_WARTOSCI_BAZOWE;
import static com.drudycja.drudycjaEngine.ui.party.partycharacter.BazoweWartosci.ELF_WARTOSCI_BAZOWE;
import static com.drudycja.drudycjaEngine.ui.party.partycharacter.BazoweWartosci.KRASNOLUD_WARTOSCI_BAZOWE;
import static com.drudycja.drudycjaEngine.ui.party.partycharacter.BazoweWartosci.NIZIOL_WARTOSCI_BAZOWE;

public enum Race {
    CZLOWIEK(R.string.lab_man, CZLOWIEK_WARTOSCI_BAZOWE, 0),
    ELF(R.string.lab_elf, ELF_WARTOSCI_BAZOWE, 1),
    KRASNOLUD(R.string.lab_dwarf, KRASNOLUD_WARTOSCI_BAZOWE, 2),
    NIZIOL(R.string.lab_halfling, NIZIOL_WARTOSCI_BAZOWE, 3);

    public final int raceNameId;
    public final int[] baseValues;
    public final int raceId;

    Race(int raceNameId, int[] baseValues, int raceId) {
        this.raceNameId = raceNameId;
        this.baseValues = baseValues;
        this.raceId = raceId;
    }

    public static Race fromRaceId(int raceId) throws IncorrectRaceIdException {
        switch (raceId) {
            case 0:
                return CZLOWIEK;
            case 1:
                return ELF;
            case 2:
                return KRASNOLUD;
            case 3:
                return NIZIOL;
            default:
                throw new IncorrectRaceIdException();
        }
    }
}
