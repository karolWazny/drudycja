package com.drudycja.drudycjaEngine.walka;

import java.util.ArrayList;
import java.util.List;

public class Battle implements IBattleObject {
    private List<ICharacterInBattleItem> characters;

    @Override
    public List<NameFlagsBean> getCharacterNameAndFlags() {//todo zmienić tablicę na databean
        List<NameFlagsBean> characterNameAndFlags = new ArrayList<>();
        for (ICharacterInBattleItem character : characters) {
            characterNameAndFlags.add(character.getNameAndFlags());
        }
        return characterNameAndFlags;
    }
}
