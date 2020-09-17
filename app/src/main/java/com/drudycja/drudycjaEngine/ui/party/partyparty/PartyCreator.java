package com.drudycja.drudycjaEngine.ui.party.partyparty;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.database.MyDatabaseHelper;

public class PartyCreator extends AppCompatActivity implements View.OnClickListener {

    private Button confirmButt;
    private Button cancelButt;
    private MyDatabaseHelper myDatabaseHelper;
    private TextView nameView;
    private TextView uwagiView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_creator);
        myDatabaseHelper = new MyDatabaseHelper(this);
        setupButtons();
        findTextViews();
    }

    private void setupButtons() {
        findButtons();
        setButtonsListeners();
    }

    private void findButtons() {
        confirmButt = findViewById(R.id.party_creator_confirm_butt);
        cancelButt = findViewById(R.id.party_creator_cancel_butt);
    }

    private void setButtonsListeners() {
        confirmButt.setOnClickListener(this);
        cancelButt.setOnClickListener(this);
    }

    private void findTextViews() {
        nameView = findViewById(R.id.partty_name_input);
        uwagiView = findViewById(R.id.party_uwagi_input);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.party_creator_confirm_butt:
                savePartyAndFinish();
            case R.id.party_creator_cancel_butt:
                finish();
        }
    }

    private void savePartyAndFinish() {
        saveParty();
        finish();
    }

    private void saveParty() {
        PartyDataPackage partyDataPackage = readFromInput();
        myDatabaseHelper.addParty(partyDataPackage);
    }

    private PartyDataPackage readFromInput() {
        return null; //todo
    }

    public static class PartyDataPackage {
    }
}
