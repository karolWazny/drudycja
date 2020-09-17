package com.drudycja.drudycjaEngine.walka;

import java.util.LinkedList;
import java.util.List;

public class CharacterInBattle implements ICharacterInBattleItem, Comparable {
    private int initiative;
    private List<String> flags;
    private String name;
    private Characteristic[] characteristics;

    private CharacterInBattle(CharacterBuilder builder) {
        flags = builder.flags;
        name = builder.name;
        initiative = builder.initiative;
    }

    public void attack(CharacterInBattle target) {
        //todo implementacja
    }

    public int getTestingValue(Characteristic.CharacteristicName characteristicName) {
        return characteristics[characteristicName.index].getTestingValue();
    }

    @Override
    public int getInitiative() {
        return initiative;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFlags() {
        return flagsToString();
    }

    private String flagsToString() {
        if (flags.isEmpty()) {
            return "";
        }
        String out = "";
        for (String flag : flags) {
            out += flag;
            out += " ";
        }
        return out.substring(0, out.length() - 1);
    }

    @Override
    public void addFlag(String flag) {
        if (!hasFlag(flag)) {
            flags.add(flag);
        }
    }

    private boolean hasFlag(String flag) {
        return flags.contains(flag);
    }

    @Override
    public void removeFlag(String flag) {
        flags.remove(flag);
    }

    @Override
    public NameFlagsInitiativeBean getNameFlagsInitiative() {
        NameFlagsInitiativeBean bean = new NameFlagsInitiativeBean();
        bean.name = name;
        bean.initiative = initiative;
        bean.flags = flagsToString();
        return bean;
    }

    @Override
    public int[] getCharacteristics() {
        return new int[0];
    }//todo nazwa

    @Override
    public int compareTo(Object o) {
        if (o instanceof CharacterInBattle) {
            return Integer.compare(((CharacterInBattle) o).getInitiative(), this.initiative);
        } else return 1;
    }

    public static class CharacterBuilder {
        private int initiative;
        private String name;
        private List<String> flags;

        public CharacterBuilder() {
            flags = new LinkedList<>();
        }

        public CharacterBuilder addName(String name) {
            this.name = name;
            return this;
        }

        public CharacterBuilder addFlag(String flag) {
            flags.add(flag);
            return this;
        }

        public CharacterBuilder addInitiative(int initiative) {
            this.initiative = initiative;
            return this;
        }

        public CharacterInBattle build() {
            return new CharacterInBattle(this);
        }
    }
}
