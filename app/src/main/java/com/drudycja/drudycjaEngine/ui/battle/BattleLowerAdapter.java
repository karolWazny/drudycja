package com.drudycja.drudycjaEngine.ui.battle;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class BattleLowerAdapter extends FragmentStateAdapter {
    private BattleActivity parent;

    public BattleLowerAdapter(Fragment fragment) {
        super(fragment);
    }

    public BattleLowerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.parent = (BattleActivity) fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        if (position == 0) {
            return new BattleActionFragment(parent);
        }
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
