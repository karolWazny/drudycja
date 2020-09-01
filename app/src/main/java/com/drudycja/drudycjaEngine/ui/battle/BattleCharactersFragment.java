package com.drudycja.drudycjaEngine.ui.battle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;

public class BattleCharactersFragment extends Fragment {
    private BattleObject battleObject;

    public BattleCharactersFragment(BattleObject battleObject) {
        this.battleObject = battleObject;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.battle_characters_recycler);
        assert recyclerView != null;
        setupRecyclerView(recyclerView);
        return view;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new BattleCharacterAdapter(this,
                battleObject.getCharacters()));
    }
}
