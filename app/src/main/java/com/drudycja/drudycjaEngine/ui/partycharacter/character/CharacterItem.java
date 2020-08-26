package com.drudycja.drudycjaEngine.ui.partycharacter.character;

public class CharacterItem {
    public final int id;
    public final String name;
    public final String race;
    public final String profession;

    public CharacterItem(int id, String name, String race, String profession) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.profession = profession;
    }
}
