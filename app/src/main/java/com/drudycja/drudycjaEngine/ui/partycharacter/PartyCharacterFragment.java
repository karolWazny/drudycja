package com.drudycja.drudycjaEngine.ui.partycharacter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.PartyFragment;

import static com.drudycja.R.id.new_character_button;
import static com.drudycja.R.string;

public class PartyCharacterFragment extends PartyFragment{

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        buttonId = new_character_button;
        layoutId = R.layout.fragment_party_character;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case new_character_button:
                Toast toast = Toast.makeText(getContext(), string.lab_wyjscie, Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}
