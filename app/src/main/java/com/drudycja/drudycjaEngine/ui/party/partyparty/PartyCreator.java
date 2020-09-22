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
        setupViews();
    }

    private void setupViews() {
        findViews();
        setButtonsListeners();
    }

    private void findViews() {
        confirmButt = findViewById(R.id.party_creator_confirm_butt);
        cancelButt = findViewById(R.id.party_creator_cancel_butt);
        nameView = findViewById(R.id.partty_name_input);
        uwagiView = findViewById(R.id.party_uwagi_input);
    }

    private void setButtonsListeners() {
        confirmButt.setOnClickListener(this);
        cancelButt.setOnClickListener(this);
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
        PartyDataPackage partyDataPackage = new PartyDataPackage();
        partyDataPackage.name = String.valueOf(nameView.getText());
        partyDataPackage.uwagi = String.valueOf(uwagiView.getText());
        return partyDataPackage;
    }

    public static class PartyDataPackage {
        public String name;
        public String uwagi;
    }
}
