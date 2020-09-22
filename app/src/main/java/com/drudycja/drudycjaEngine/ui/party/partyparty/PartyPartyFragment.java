package com.drudycja.drudycjaEngine.ui.party.partyparty;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.party.PartyFragment;

import static com.drudycja.R.id.new_party_button;

public class PartyPartyFragment extends PartyFragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        buttonId = R.id.new_party_button;
        layoutId = R.layout.fragment_party_party;
        View view = super.onCreateView(inflater, container, savedInstanceState);
        View recyclerView = view.findViewById(R.id.party_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case new_party_button:
                startPartyCreator();
                break;
        }
    }

    private void startPartyCreator() {
        Intent intent = new Intent(getActivity(), PartyCreator.class);
        startActivity(intent);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new PartyRecyclerViewAdapter(this,
                getDatabaseHelper().getPartyItems()));
    }

}
