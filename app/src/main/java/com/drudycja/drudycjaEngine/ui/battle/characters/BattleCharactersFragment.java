package com.drudycja.drudycjaEngine.ui.battle.characters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.battle.BattleActivity;
import com.drudycja.drudycjaEngine.walka.Battle;

public class BattleCharactersFragment extends Fragment {
    private Battle battle;
    private BattleActivity parent;

    public BattleCharactersFragment(Battle battle, BattleActivity parent) {
        this.battle = battle;
        this.parent = parent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle_characters, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.battle_characters_recycler);
        assert recyclerView != null;
        setupRecyclerView(recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new BattleCharacterAdapter(this,
                battle.getCharacterNameFlagsInitiative(),
                parent));
    }

}
