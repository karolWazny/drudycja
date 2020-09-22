package com.drudycja.drudycjaEngine.database.party;

public class PartyItem {
    public int id;
    public String name;

    public PartyItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
