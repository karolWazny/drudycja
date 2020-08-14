package com.drudycja.drudycjaEngine.ui.partyfoes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.PartyFragment;

import static com.drudycja.R.id.new_foe_button;

public class PartyFoesFragment extends PartyFragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        buttonId = R.id.new_foe_button;
        layoutId = R.layout.fragment_party_foes;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case new_foe_button:
                Toast toast = Toast.makeText(getContext(), R.string.lab_wyjscie, Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}
