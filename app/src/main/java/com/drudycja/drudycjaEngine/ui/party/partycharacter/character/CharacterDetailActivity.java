package com.drudycja.drudycjaEngine.ui.party.partycharacter.character;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.database.MyDatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

public class CharacterDetailActivity extends AppCompatActivity {

    public static final String ARG_CHARACTER_ID = "characterId";
    private int characterId;
    private TextInputEditText[] maxValueFields;
    private TextInputEditText nameField;
    private TextInputEditText raceField;
    private TextInputEditText professionField;
    private MyDatabaseHelper myDatabaseHelper;
    private CharacterItem character;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        findMaxValueFields();
        findBasicInfoFields();
        myDatabaseHelper = new MyDatabaseHelper(this);
        characterId = getIntent().getIntExtra(ARG_CHARACTER_ID, 0);
        try {
            character = myDatabaseHelper.getCharacterWithId(characterId);
            nameField.setText(character.name);
            raceField.setText(character.race);
            professionField.setText(character.profession);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setMaxValueFieldsValues();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater wypelniacz = getMenuInflater();
        wypelniacz.inflate(R.menu.character_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.character_delete_action:
                openDeleteCharacterDialog();
                break;
            case R.id.character_edit_action:
                startEditScreen();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openDeleteCharacterDialog() {//todo strings in dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_delete_character)
                .setPositiveButton(R.string.lab_yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        deleteCharacter();
                        finish();
                    }
                })
                .setNegativeButton(R.string.lab_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        builder.create().show();
    }

    private void startEditScreen() {
    }

    private void deleteCharacter() {
        myDatabaseHelper.deleteCharacterWithId(characterId);
    }

    private void findMaxValueFields() {
        maxValueFields = new TextInputEditText[8];
        maxValueFields[0] = findViewById(R.id.ch_detail_ww_max);
        maxValueFields[1] = findViewById(R.id.ch_detail_us_max);
        maxValueFields[2] = findViewById(R.id.ch_detail_k_max);
        maxValueFields[3] = findViewById(R.id.ch_detail_odp_max);
        maxValueFields[4] = findViewById(R.id.ch_detail_zr_max);
        maxValueFields[5] = findViewById(R.id.ch_detail_int_max);
        maxValueFields[6] = findViewById(R.id.ch_detail_sw_max);
        maxValueFields[7] = findViewById(R.id.ch_detail_ogd_max);
    }

    private void setMaxValueFieldsValues() {
        for (int i = 0; i < 8; i++) {
            maxValueFields[i].setText(String.valueOf(character.charakterystykiMaks[i]));
        }
    }

    private void findBasicInfoFields() {
        nameField = findViewById(R.id.ch_detail_name);
        raceField = findViewById(R.id.ch_detail_race);
        professionField = findViewById(R.id.ch_detail_profession);
    }
}
