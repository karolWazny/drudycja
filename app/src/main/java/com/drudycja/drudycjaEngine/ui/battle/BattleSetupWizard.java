package com.drudycja.drudycjaEngine.ui.battle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.walka.CharacterInBattle;

import java.util.List;

public class BattleSetupWizard extends Activity
        implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private List<CharacterInBattle> characters;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_setup_wizard);
        findAndSetupButton();
        setupCampaignSpinner();
    }

    private void findAndSetupButton() {
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startBattleAndFinishWizard();
        }
    }

    private void startBattle() {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }

    private void startBattleAndFinishWizard() {
        startBattle();
        finish();
    }

    private void setupCampaignSpinner() {
        Spinner raceSpinner = findViewById(R.id.campaign_spinner);
        ArrayAdapter<CharSequence> raceSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.races_array,
                android.R.layout.simple_spinner_item);
        raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceSpinner.setAdapter(raceSpinnerAdapter);
        raceSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
