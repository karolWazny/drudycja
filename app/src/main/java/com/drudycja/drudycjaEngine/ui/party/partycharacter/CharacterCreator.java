package com.drudycja.drudycjaEngine.ui.party.partycharacter;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.database.MyDatabaseHelper;
import com.drudycja.drudycjaEngine.ui.party.partycharacter.character.Race;
import com.google.android.material.textfield.TextInputEditText;

import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_CHARAKTERYSTYKI_POCZATKOWE;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_IMIE;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_PROFESJA;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_RASA;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_TABELA;

public class CharacterCreator extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener,
        AdapterView.OnItemSelectedListener {//todo skrócić metody
    //todo pozbyć się switcha
    //todo oddzielić id Stringa z nazwą rasy od zapisu rasy do db

    private TextInputEditText imieTextField;
    private TextInputEditText profesjaTextField;
    private TextInputEditText[] bazowe;
    private TextInputEditText[] rolls;
    private TextInputEditText[] sumy;
    private MyDatabaseHelper myDatabaseHelper;
    private Race race;
    private Button confirmButt;
    private Button cancelButt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creator);
        myDatabaseHelper = new MyDatabaseHelper(this);
        race = Race.CZLOWIEK;
        setupAllViews();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.character_creator_confirm_butt:
                try {
                    saveCharacterToDatabase();
                    this.finish();
                } catch (Exception e) {
                    Toast.makeText(this, R.string.toast_puste_pola, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.character_creator_cancel_butt:
                this.finish();
                break;
        }
    }

    private void saveCharacterToDatabase() throws Exception {
        CharacterDataPackage character = readCharacterFromInputPanel();
        SQLiteDatabase database = myDatabaseHelper.getWritableDatabase();
        ContentValues characterRecord = characterDataToContentValues(character);
        database.insert(POSTACIE_TABELA, null, characterRecord);
        database.close();
    }

    private CharacterDataPackage readCharacterFromInputPanel() throws Exception {
        if (areEmptyFields()) {
            throw new Exception();
        }
        CharacterDataPackage character = new CharacterDataPackage();
        character.imie = imieTextField.getText().toString();
        character.profesja = profesjaTextField.getText().toString();
        character.raceId = race.raceNameId;
        for (int i = 0; i < 8; i++) {
            character.charakterystyki[i] = (Byte.parseByte(String.valueOf(sumy[i].getText())));
        }
        for (int i = 8; i < 16; i++) {
            character.charakterystyki[i] = 5;
        }
        return character;
    }

    private ContentValues characterDataToContentValues(CharacterDataPackage characterDataPackage) {
        ContentValues characterRecord = new ContentValues();
        characterRecord.put(POSTACIE_IMIE, characterDataPackage.imie);
        characterRecord.put(POSTACIE_RASA, characterDataPackage.raceId);
        characterRecord.put(POSTACIE_PROFESJA, characterDataPackage.profesja);
        characterRecord.put(POSTACIE_CHARAKTERYSTYKI_POCZATKOWE, characterDataPackage.charakterystyki);
        return characterRecord;
    }

    private void loadBaseValues() {
        int[] values = race.baseValues;
        for (int i = 0; i < 8; i++) {
            bazowe[i].setText(String.valueOf(values[i]));
        }
    }

    private void setupAllViews() {
        setupButtons();
        setupRaceSpinner();
        findAllTextFields();
        loadBaseValuesAndRefreshSums();
        setRollsListeners();
    }

    private void setupRaceSpinner() {
        Spinner raceSpinner = findViewById(R.id.race_spinner);
        ArrayAdapter<CharSequence> raceSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.races_array,
                android.R.layout.simple_spinner_item);
        raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceSpinner.setAdapter(raceSpinnerAdapter);
        raceSpinner.setOnItemSelectedListener(this);
    }

    private void setupButtons() {
        findButtons();
        setButtonListeners();
    }

    private void findButtons() {
        confirmButt = findViewById(R.id.character_creator_confirm_butt);
        cancelButt = findViewById(R.id.character_creator_cancel_butt);
    }

    private void setButtonListeners() {
        confirmButt.setOnClickListener(this);
        cancelButt.setOnClickListener(this);
    }

    private void findAllTextFields() {
        imieTextField = findViewById(R.id.ch_creator_input_name);
        profesjaTextField = findViewById(R.id.ch_creator_input_profession);
        findBazowe();
        findRolls();
        findSumy();
    }

    private void findBazowe() {
        bazowe = new TextInputEditText[8];
        bazowe[0] = findViewById(R.id.creator_input_ww_base);
        bazowe[1] = findViewById(R.id.creator_input_us_base);
        bazowe[2] = findViewById(R.id.creator_input_k_base);
        bazowe[3] = findViewById(R.id.creator_input_odp_base);
        bazowe[4] = findViewById(R.id.creator_input_zr_base);
        bazowe[5] = findViewById(R.id.creator_input_int_base);
        bazowe[6] = findViewById(R.id.creator_input_sw_base);
        bazowe[7] = findViewById(R.id.creator_input_ogd_base);
    }

    private void findRolls() {
        rolls = new TextInputEditText[8];
        rolls[0] = findViewById(R.id.creator_input_ww_roll);
        rolls[1] = findViewById(R.id.creator_input_us_roll);
        rolls[2] = findViewById(R.id.creator_input_k_roll);
        rolls[3] = findViewById(R.id.creator_input_odp_roll);
        rolls[4] = findViewById(R.id.creator_input_zr_roll);
        rolls[5] = findViewById(R.id.creator_input_int_roll);
        rolls[6] = findViewById(R.id.creator_input_sw_roll);
        rolls[7] = findViewById(R.id.creator_input_ogd_roll);
    }

    private void findSumy() {
        sumy = new TextInputEditText[8];
        sumy[0] = findViewById(R.id.creator_input_ww_sum);
        sumy[1] = findViewById(R.id.creator_input_us_sum);
        sumy[2] = findViewById(R.id.creator_input_k_sum);
        sumy[3] = findViewById(R.id.creator_input_odp_sum);
        sumy[4] = findViewById(R.id.creator_input_zr_sum);
        sumy[5] = findViewById(R.id.creator_input_int_sum);
        sumy[6] = findViewById(R.id.creator_input_sw_sum);
        sumy[7] = findViewById(R.id.creator_input_ogd_sum);
    }

    private void setRollsListeners() {
        for (TextInputEditText textInputEditText : rolls) {
            textInputEditText.setOnEditorActionListener(this);
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            refreshSum(textView);
            return false;
        }
        return true;
    }

    private void refreshSum(TextView textView) {
        switch (textView.getId()) {
            case R.id.creator_input_ww_roll:
                addRollToBaseAndRefreshSum(R.id.creator_input_ww_base, textView, R.id.creator_input_ww_sum);
                break;
            case R.id.creator_input_us_roll:
                addRollToBaseAndRefreshSum(R.id.creator_input_us_base, textView, R.id.creator_input_us_sum);
                break;
            case R.id.creator_input_k_roll:
                addRollToBaseAndRefreshSum(R.id.creator_input_k_base, textView, R.id.creator_input_k_sum);
                break;
            case R.id.creator_input_odp_roll:
                addRollToBaseAndRefreshSum(R.id.creator_input_odp_base, textView, R.id.creator_input_odp_sum);
                break;
            case R.id.creator_input_zr_roll:
                addRollToBaseAndRefreshSum(R.id.creator_input_zr_base, textView, R.id.creator_input_zr_sum);
                break;
            case R.id.creator_input_int_roll:
                addRollToBaseAndRefreshSum(R.id.creator_input_int_base, textView, R.id.creator_input_int_sum);
                break;
            case R.id.creator_input_sw_roll:
                addRollToBaseAndRefreshSum(R.id.creator_input_sw_base, textView, R.id.creator_input_sw_sum);
                break;
            case R.id.creator_input_ogd_roll:
                addRollToBaseAndRefreshSum(R.id.creator_input_ogd_base, textView, R.id.creator_input_ogd_sum);
                break;
        }
    }

    private void addRollToBaseAndRefreshSum(int baseTextId, TextView rollText, int sumTextId) {
        int value = Integer.parseInt(String.valueOf(((TextInputEditText) findViewById(baseTextId)).getText()));
        try {
            value += Integer.parseInt(String.valueOf(rollText.getText()));
        } catch (NumberFormatException e) {
        }
        ((TextInputEditText) findViewById(sumTextId)).setText(String.valueOf(value));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (position) {
            case 0:
                race = Race.CZLOWIEK;
                break;
            case 1:
                race = Race.ELF;
                break;
            case 2:
                race = Race.KRASNOLUD;
                break;
            case 3:
                race = Race.NIZIOL;
                break;
            default:
                break;
        }
        loadBaseValuesAndRefreshSums();
    }

    private void loadBaseValuesAndRefreshSums() {
        loadBaseValues();
        refreshAllSums();
    }

    private void refreshAllSums() {
        for (TextInputEditText textInputEditText : rolls) {
            refreshSum(textInputEditText);
        }
    }

    private boolean areEmptyFields() {
        if (imieTextField.getText().length() == 0)
            return true;
        if (profesjaTextField.getText().length() == 0)
            return true;
        for (TextInputEditText textView : rolls) {
            if (textView.getText().length() == 0)
                return true;
        }
        return false;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    static class CharacterDataPackage {
        public byte[] charakterystyki;
        public String imie;
        public String profesja;
        public long raceId;

        public CharacterDataPackage() {
            charakterystyki = new byte[16];
        }
    }
}
