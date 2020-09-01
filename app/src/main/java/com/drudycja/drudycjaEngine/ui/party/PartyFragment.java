package com.drudycja.drudycjaEngine.ui.party;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public abstract class PartyFragment extends Fragment implements View.OnClickListener{

    protected int buttonId;
    protected int layoutId;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId, null);
        View newCharacterButton = view.findViewById(buttonId);
        newCharacterButton.setOnClickListener(this);
        return view;
    }


}
