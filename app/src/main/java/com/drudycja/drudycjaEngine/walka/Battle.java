package com.drudycja.drudycjaEngine.walka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.sort;

public class Battle {
    private List<CharacterInBattle> characters;
    private List<NameFlagsInitiativeBean> nameFlagsInitiativeBeans;
    private boolean nameFlagsInitiativeUpToDate;

    public Battle() {
        characters = new ArrayList<>();
        nameFlagsInitiativeUpToDate = false;
    }

    private Battle(List<CharacterInBattle> characters) {
        this.characters = characters;
        nameFlagsInitiativeUpToDate = false;
    }

    public static Battle fromCharactersList(List<CharacterInBattle> characters) {
        return new Battle(characters);
    }

    public List<NameFlagsInitiativeBean> getCharacterNameFlagsInitiative() {
        if (nameFlagsInitiativeUpToDate) {
            return nameFlagsInitiativeBeans;
        }
        nameFlagsInitiativeBeans = new LinkedList<>();
        for (CharacterInBattle character : characters) {
            nameFlagsInitiativeBeans.add(character.getNameFlagsInitiative());
        }
        nameFlagsInitiativeUpToDate = true;
        return nameFlagsInitiativeBeans;
    }

    public void addCharacter(CharacterInBattle character) {
        characters.add(character);
        sort(characters);
        nameFlagsInitiativeUpToDate = false;
    }

    public void addCharacters(List<CharacterInBattle> characters) {
        this.characters.addAll(characters);
        sort(characters);
        nameFlagsInitiativeUpToDate = false;
    }
}
