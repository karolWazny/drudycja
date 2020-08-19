package com.drudycja.drudycjaEngine.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.partycharacter.ItemFragment;
import com.drudycja.drudycjaEngine.ui.partyfoes.PartyFoesFragment;
import com.drudycja.drudycjaEngine.ui.partyparty.PartyPartyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class PartyMenu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch(item.getItemId()){
                case R.id.partyNavigationCharacter:
                    fragment = new ItemFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.partyNavigationTeam:
                    fragment = new PartyPartyFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.partyNavigationFoes:
                    fragment = new PartyFoesFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.party_activity);
       loadFragment(new ItemFragment());
       BottomNavigationView bottomNavigationView = findViewById(R.id.party_nav_view);
       bottomNavigationView.setOnNavigationItemSelectedListener(this);
   }

    /*@Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        BottomNavigationView navigationView = findViewById(R.id.party_nav_view);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.partyNavigationCharacter, R.id.partyNavigationTeam, R.id.partyNavigationFoes)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.party_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }*/
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
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
                fragment = new ItemFragment();
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
}
