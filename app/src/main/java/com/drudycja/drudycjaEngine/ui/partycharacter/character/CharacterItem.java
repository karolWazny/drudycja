package com.drudycja.drudycjaEngine.ui.partycharacter.character;

public class CharacterItem {
    private String name;
    private String race;
    private String profession;
    private byte[] charakterystyki_poczatkowe;

    public CharacterItem(String name, String race, String profession,
                         byte[] charakterystyki_poczatkowe) {
        this.name = name;
        this.race = race;
        this.profession = profession;
        this.charakterystyki_poczatkowe = charakterystyki_poczatkowe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public byte[] getCharakterystyki_poczatkowe() {
        return charakterystyki_poczatkowe;
    }

    public void setCharakterystyki_poczatkowe(byte[] charakterystyki_poczatkowe) {
        this.charakterystyki_poczatkowe = charakterystyki_poczatkowe;
    }
}
