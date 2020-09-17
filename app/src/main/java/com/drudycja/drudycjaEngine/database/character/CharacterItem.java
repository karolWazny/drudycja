package com.drudycja.drudycjaEngine.database.character;

public class CharacterItem {
    public final int id;
    public final String name;
    public final Race race;
    public final String profession;
    public final byte[] charakterystykiMaks;
    public final byte[] charakterystykiChwilowe;

    public CharacterItem(int id, String name, Race race, String profession,
                         byte[] charakterystykiMaks, byte[] charakterystykiChwilowe) {
        this.id = id;
        this.name = name;
        //this.race = MainActivity.getRes().getString(raceId);
        this.race = race;
        this.profession = profession;
        this.charakterystykiMaks = charakterystykiMaks;
        this.charakterystykiChwilowe = charakterystykiChwilowe;
    }

    public CharacterItem(int id, String name, Race race, String profession) {
        this(id, name, race, profession, null, null);
    }
}
