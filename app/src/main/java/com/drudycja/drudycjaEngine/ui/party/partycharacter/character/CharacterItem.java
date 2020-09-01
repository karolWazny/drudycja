package com.drudycja.drudycjaEngine.ui.party.partycharacter.character;

import com.drudycja.drudycjaEngine.ui.MainActivity;

public class CharacterItem {
    public final int id;
    public final String name;
    public final String race;
    public final String profession;
    public final byte[] charakterystykiMaks;
    public final byte[] charakterystykiChwilowe;

    public CharacterItem(int id, String name, int raceId, String profession,
                         byte[] charakterystykiMaks, byte[] charakterystykiChwilowe) {
        this.id = id;
        this.name = name;
        this.race = MainActivity.getRes().getString(raceId);
        this.profession = profession;
        this.charakterystykiMaks = charakterystykiMaks;
        this.charakterystykiChwilowe = charakterystykiChwilowe;
    }

    public CharacterItem(int id, String name, int race, String profession) {
        this(id, name, race, profession, null, null);
    }
}
