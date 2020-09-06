package com.drudycja.drudycjaEngine.ui.battle.characters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.walka.IBattleObject;

public class BattleCharactersFragment extends Fragment {
    private IBattleObject IBattleObject;

    public BattleCharactersFragment(IBattleObject IBattleObject) {
        this.IBattleObject = IBattleObject;
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
                IBattleObject.getCharacterNameAndFlags()));
    }
}
