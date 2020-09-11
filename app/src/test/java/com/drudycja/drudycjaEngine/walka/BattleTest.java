package com.drudycja.drudycjaEngine.walka;

import org.junit.Test;

import java.util.List;

public class BattleTest {
    @Test
    public void addingCharacter_sort_test() {
        Battle battle = new Battle();
        CharacterInBattle.CharacterBuilder builder = new CharacterInBattle.CharacterBuilder();
        battle.addCharacter(builder.addInitiative(10)
                .build());
        battle.addCharacter(builder.addInitiative(30)
                .build());
        battle.addCharacter(builder.addInitiative(20)
                .build());
        List<NameFlagsInitiativeBean> beans = battle.getCharacterNameFlagsInitiative();
        for (int i = 0; i < 2; i++) {
            assert beans.get(i).initiative > beans.get(i + 1).initiative;
        }
    }

    @Test
    public void performAction_test() {
        Battle battle = new Battle();
    }
}
