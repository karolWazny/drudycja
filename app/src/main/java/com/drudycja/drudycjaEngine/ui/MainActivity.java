package com.drudycja.drudycjaEngine.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.drudycja.R;

public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        View partyButton = findViewById(R.id.party_button);
        partyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.party_button:
                Intent i = new Intent(this, PartyMenu.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
