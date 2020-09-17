package com.drudycja.drudycjaEngine.ui.battle;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.walka.Battle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class BattleActivity extends FragmentActivity {

    private BattleUpperAdapter upperAdapter;
    private BattleLowerAdapter lowerAdapter;
    private ViewPager2 upperViewPager;
    private ViewPager2 lowerViewPager;
    private int focusedCharacterPosition;
    private int activeCharacterPosition;
    private Battle battle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        findAndSetViews();
    }

    private void findAndSetViews() {
        findViewPagers();
        setAdapters();
    }

    private void findViewPagers() {
        upperViewPager = findViewById(R.id.battle_pager_top);
        lowerViewPager = findViewById(R.id.battle_pager_bottom);
    }

    private void setAdapters() {
        setLowerAdapter();
        setUpperAdapter();
    }

    private void setUpperAdapter() {
        upperAdapter = new BattleUpperAdapter(this);
        upperViewPager.setAdapter(upperAdapter);
        TabLayout tabLayout = findViewById(R.id.battle_tab_top);
        new TabLayoutMediator(tabLayout, upperViewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText(R.string.title_character);
                                break;
                            case 1:
                                tab.setText(R.string.lab_log);
                                break;
                            default:
                                tab.setText("Object " + position);
                                break;
                        }
                    }
                }).attach();
    }

    private void setLowerAdapter() {
        lowerAdapter = new BattleLowerAdapter(this);
        lowerViewPager.setAdapter(lowerAdapter);
        TabLayout tabLayout = findViewById(R.id.battle_tab_bottom);
        new TabLayoutMediator(tabLayout, lowerViewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText(R.string.lab_actions);
                                break;
                            case 1:
                                tab.setText(R.string.lab_details);
                                break;
                            default:
                                tab.setText("Object " + position);
                                break;
                        }
                    }
                }).attach();
    }

    public int getFocusedCharacterPosition() {
        return focusedCharacterPosition;
    }

    public void setFocusedCharacterPosition(int focusedCharacterPosition) {
        this.focusedCharacterPosition = focusedCharacterPosition;
    }

    public int getActiveCharacterPosition() {
        return activeCharacterPosition;
    }

    public void setActiveCharacterPosition(int activeCharacterPosition) {
        this.activeCharacterPosition = activeCharacterPosition;
    }

    public Battle getBattle() {
        return battle;
    }
}
