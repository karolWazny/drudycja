package com.drudycja.drudycjaEngine.walka;

import java.util.LinkedList;
import java.util.List;

public class CharacterInBattle implements ICharacterInBattleItem {
    private int initiative;
    private List<String> flags;
    private String name;

    private CharacterInBattle(CharacterBuilder builder) {
        flags = builder.flags;
        name = builder.name;
        initiative = builder.initiative;
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

    private String flagsToString() {
        String out = "";
        for (String flag : flags) {
            out += flag;
            out += " ";
        }
        return out.substring(0, out.length() - 1);
    }

    @Override
    public NameFlagsBean getNameAndFlags() {
        return null;
    }

    @Override
    public int[] getStatistics() {
        return new int[0];
    }//todo nazwa

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
