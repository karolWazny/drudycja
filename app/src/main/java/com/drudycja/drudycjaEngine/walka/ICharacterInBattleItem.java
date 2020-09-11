package com.drudycja.drudycjaEngine.walka;

public interface ICharacterInBattleItem {//todo nazwa

    int getInitiative();

    String getName();

    String getFlags();

    void addFlag(String flag);

    void removeFlag(String flag);

    NameFlagsInitiativeBean getNameFlagsInitiative(); //todo znaleźć dobrą nazwę

    int[] getCharacteristics();
}
