package com.drudycja.drudycjaEngine.ui.party;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.drudycja.drudycjaEngine.database.MyDatabaseHelper;

public abstract class PartyFragment extends Fragment implements View.OnClickListener {

    protected int buttonId;
    protected int layoutId;
    private static MyDatabaseHelper myDatabaseHelper;

    public PartyFragment newInstance()
            throws IllegalAccessException, java.lang.InstantiationException {
        return getClass().newInstance();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabaseHelper = new MyDatabaseHelper(getContext());
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId, null);
        View newCharacterButton = view.findViewById(buttonId);
        newCharacterButton.setOnClickListener(this);
        return view;
    }

    public MyDatabaseHelper getDatabaseHelper() {
        return myDatabaseHelper;
    }
}
