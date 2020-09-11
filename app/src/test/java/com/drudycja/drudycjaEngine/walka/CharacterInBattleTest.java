package com.drudycja.drudycjaEngine.walka;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterInBattleTest {
    @Test
    public void flags_test() {
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        builder.addFlag("Zmeczony");
        builder.addFlag("nieprzytomny");
        CharacterInBattle character = builder.build();
        assert character.getFlags().equals("Zmeczony nieprzytomny");
    }

    @Test
    public void name_test() {
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        builder.addName("Fred");
        CharacterInBattle character = builder.build();
        assert character.getName().equals("Fred");
    }

    @Test
    public void initiative_test() {
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        builder.addInitiative(20);
        CharacterInBattle character_20 = builder.build();
        assert character_20.getInitiative() == 20;

        builder = new CharacterInBattle.CharacterBuilder();
        builder.addInitiative(30);
        CharacterInBattle character_30 = builder.build();
        assert character_30.getInitiative() == 30;
    }

    @Test
    public void characterAddFlag_test() {
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        builder.addFlag("Zmeczony");
        CharacterInBattle character = builder.build();
        assert character.getFlags().equals("Zmeczony");
        character.addFlag("nieprzytomny");
        assert character.getFlags().equals("Zmeczony nieprzytomny");
    }

    @Test
    public void addingExistingFlag_test() {
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        builder.addFlag("Zmeczony");
        CharacterInBattle character = builder.build();
        assert character.getFlags().equals("Zmeczony");
        character.addFlag("Zmeczony");
        assert character.getFlags().equals("Zmeczony");
    }

    @Test
    public void removeFlag_test() {
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        builder.addFlag("Zmeczony");
        builder.addFlag("nieprzytomny");
        CharacterInBattle character = builder.build();
        assert character.getFlags().equals("Zmeczony nieprzytomny");
        character.removeFlag("nieprzytomny");
        assert character.getFlags().equals("Zmeczony");
    }

    @Test
    public void removeNonExistingFlag_test() {
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        builder.addFlag("Zmeczony");
        CharacterInBattle character = builder.build();
        character.removeFlag("nieprzytomny");
        assert character.getFlags().equals("Zmeczony");
    }

    @Test
    public void getEmptyFlags_test() {
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        CharacterInBattle character = builder.build();
        assertEquals(character.getFlags(), "");
    }

    @Test
    public void getInitiative_test() {
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        builder.addInitiative(20);
        CharacterInBattle character = builder.build();
        assertEquals(character.getInitiative(), 20);
        builder = new CharacterInBattle.CharacterBuilder();
        builder.addInitiative(30);
        character = builder.build();
        assertEquals(character.getInitiative(), 30);
    }
}
