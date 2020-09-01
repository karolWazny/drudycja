package com.drudycja.drudycjaEngine.ui.party.partyparty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.party.PartyFragment;

import static com.drudycja.R.id.new_party_button;

public class PartyPartyFragment extends PartyFragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        buttonId = R.id.new_party_button;
        layoutId = R.layout.fragment_party_party;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case new_party_button:
                Toast toast = Toast.makeText(getContext(), R.string.lab_wyjscie, Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}
