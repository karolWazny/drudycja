package com.drudycja.drudycjaEngine.ui.battle;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.drudycja.drudycjaEngine.ui.battle.characters.BattleCharactersFragment;
import com.drudycja.drudycjaEngine.walka.Battle;
import com.drudycja.drudycjaEngine.walka.CharacterInBattle;

public class BattleUpperAdapter extends FragmentStateAdapter {
    public BattleUpperAdapter(Fragment fragment) {
        super(fragment);
    }

    public BattleUpperAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            Battle battle = new Battle();
            battle.addCharacter(new CharacterInBattle.CharacterBuilder()
                    .addName("Fred")
                    .addFlag("zmeczony")
                    .addInitiative(30)
                    .build());
            return new BattleCharactersFragment(battle);//todo faktyczna implementacja rzeczywistej bitwy
        }
        // Return a NEW fragment instance in createFragment(int)
        Fragment fragment = new DemoObjectFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(DemoObjectFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
