package com.drudycja.drudycjaEngine.ui.party.partycharacter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.party.PartyFragment;

import static com.drudycja.R.id.new_character_button;

public class PartyCharacterFragment extends PartyFragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        buttonId = new_character_button;
        layoutId = R.layout.fragment_party_character;
        View view = super.onCreateView(inflater, container, savedInstanceState);
        View recyclerView = view.findViewById(R.id.character_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case new_character_button:
                startCharacterCreator();
                break;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new CharacterRecyclerViewAdapter(this,
                getDatabaseHelper().getPCList()));
    }

    private void startCharacterCreator() {
        Intent intent = new Intent(getActivity(), CharacterCreator.class);
        startActivity(intent);
    }
}
