package com.drudycja.drudycjaEngine.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.battle.BattleActivity;
import com.drudycja.drudycjaEngine.ui.party.PartyMenu;

public class MainActivity extends Activity implements View.OnClickListener {

    private static Resources resources;

    public static Resources getRes() {
        return resources;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        View partyButton = findViewById(R.id.party_button);
        partyButton.setOnClickListener(this);
        View newBattleButton = findViewById(R.id.new_battle_button);
        newBattleButton.setOnClickListener(this);
        resources = getResources();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.party_button:
                openPartyMenu();
                break;
            case R.id.new_battle_button:
                startNewBattle();
                break;
            default:
                break;
        }
    }

    private void openPartyMenu() {
        Intent i = new Intent(this, PartyMenu.class);
        startActivity(i);
    }

    private void startNewBattle() {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }
}
