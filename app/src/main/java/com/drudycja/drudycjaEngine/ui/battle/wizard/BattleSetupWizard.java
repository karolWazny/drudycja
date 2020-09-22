package com.drudycja.drudycjaEngine.ui.battle.wizard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.database.MyDatabaseHelper;
import com.drudycja.drudycjaEngine.database.party.PartyItem;
import com.drudycja.drudycjaEngine.ui.battle.BattleActivity;
import com.drudycja.drudycjaEngine.walka.CharacterInBattle;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

import java.util.List;

public class BattleSetupWizard extends AppCompatActivity //todo otwierać przez startActivityForResult
        implements View.OnClickListener, AdapterView.OnItemSelectedListener, SpeedDialView.OnActionSelectedListener {
    private List<CharacterInBattle> characters;
    public final static int ADD_BLOTKA_REQUEST = 314;
    public final static int ADD_CUSTOM_BLOTKA_REQUEST = 3141;
    public final static int ADD_CHARACTER_REQUEST = 31415;
    public final static int ADD_NPC_REQUEST = 314156;
    private SpeedDialView dialView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_setup_wizard);
        findAndSetupViews();
    }

    private void findAndSetupViews() {
        findAndSetupButton();
        findAndSetupSpeedDial();
        setupCampaignSpinner();
    }

    private void findAndSetupButton() {
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    private void findAndSetupSpeedDial() {
        dialView = findViewById(R.id.floatingActionButton);
        dialView.inflate(R.menu.add_to_battle_menu);
        dialView.setOnActionSelectedListener(this);
    }

    private void setupCampaignSpinner() {
        Spinner raceSpinner = findViewById(R.id.campaign_spinner);
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        List<PartyItem> parties = myDatabaseHelper.getPartyItems();
        ArrayAdapter raceSpinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, parties);
        raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceSpinner.setAdapter(raceSpinnerAdapter);
        raceSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startBattleAndFinishWizard();
                break;
        }
    }

    private void startBattleAndFinishWizard() {
        startBattle();
        finish();
    }

    private void startBattle() {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onActionSelected(SpeedDialActionItem actionItem) {
        switch (actionItem.getId()) {
            case R.id.sp_dial_blotka:
                startAddingBlotka();
                return true;
            case R.id.sp_dial_character:
                return true;
            case R.id.sp_dial_custom_blotka:
                return true;
            case R.id.sp_dial_npc:
                return true;
        }
        return false;
    }

    private void startAddingBlotka() {
        Intent intent = new Intent(this, AddingBlotkaActivity.class);
        startActivityForResult(intent, ADD_BLOTKA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ADD_BLOTKA_REQUEST:
                break;
            case ADD_CUSTOM_BLOTKA_REQUEST:
                break;
            case ADD_NPC_REQUEST:
                break;
            case ADD_CHARACTER_REQUEST:
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
