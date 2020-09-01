package com.drudycja.drudycjaEngine.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.partycharacter.PartyCharacterFragment;
import com.drudycja.drudycjaEngine.ui.partyfoes.PartyFoesFragment;
import com.drudycja.drudycjaEngine.ui.partyparty.PartyPartyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class PartyMenu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Fragment currentFragment;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.party_activity);
       View container = findViewById(R.id.party_frame_container);
       BottomNavigationView bottomNavigationView = findViewById(R.id.party_nav_view);
       bottomNavigationView.setOnNavigationItemSelectedListener(this);
       currentFragment = new PartyCharacterFragment();
       loadFragment(currentFragment);
   }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        currentFragment = fragment;
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.party_frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        Fragment fragment = null;
        switch(item.getItemId()){
            case R.id.partyNavigationCharacter:
                fragment = new PartyCharacterFragment();
                break;
            case R.id.partyNavigationTeam:
                fragment = new PartyPartyFragment();
                break;
            case R.id.partyNavigationFoes:
                fragment = new PartyFoesFragment();
                break;

        }
        return loadFragment(fragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            loadFragment(currentFragment.getClass().newInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
