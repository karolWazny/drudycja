package com.drudycja.drudycjaEngine.ui.partycharacter;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.database.MyDatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_CHARAKTERYSTYKI_POCZATKOWE;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_IMIE;
import static com.drudycja.drudycjaEngine.database.PostacieKolumny.POSTACIE_TABELA;
import static com.drudycja.drudycjaEngine.ui.partycharacter.BazoweWartosci.CZLOWIEK_GLOWNE;

public class CharacterCreator extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {

    private TextInputEditText[] bazowe;
    private TextInputEditText[] rolls;
    private TextInputEditText[] sumy;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creator);
        myDatabaseHelper = new MyDatabaseHelper(this);
        View confirmButt = findViewById(R.id.character_creator_confirm_butt);
        confirmButt.setOnClickListener(this);
        View cancelButt = findViewById(R.id.character_creator_cancel_butt);
        cancelButt.setOnClickListener(this);
        findBazowe();
        loadBaseValues(CZLOWIEK_GLOWNE);
        findRolls();
        for (TextInputEditText textInputEditText : rolls) {
            refreshSum(textInputEditText);
        }
        setRollsListeners();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.character_creator_confirm_butt:
                try {
                    saveCHaracterToDatabase();
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

    private void saveCHaracterToDatabase() throws Exception {
        CharacterDataPackage character = readCharacterFromInputPanel();
        SQLiteDatabase database = myDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(POSTACIE_IMIE, character.imie);
        values.put(POSTACIE_CHARAKTERYSTYKI_POCZATKOWE, character.charakterystyki);
        database.insert(POSTACIE_TABELA, null, values);
        database.close();
    }

    private CharacterDataPackage readCharacterFromInputPanel() throws Exception {
        CharacterDataPackage character = new CharacterDataPackage();
        character.imie = ((TextView) findViewById(R.id.ch_creator_input_name)).getText().toString();
        character.profesja = ((TextView) findViewById(R.id.ch_creator_input_profession)).getText().toString();
        character.rasa = ((TextView) findViewById(R.id.ch_creator_input_race)).getText().toString();
        if (character.imie.equals("") || character.rasa.equals("") || character.profesja.equals("")) {
            throw new Exception();
        }
        for (int i = 0; i < 8; i++) {
            character.charakterystyki[i] = (Byte.parseByte(String.valueOf(sumy[i].getText())));
        }
        for (int i = 8; i < 16; i++) {
            character.charakterystyki[i] = 5;
        }
        return character;
    }

    private void loadBaseValues(final int[] values) {
        int[] wartosci = values;
        for (int i = 0; i < 8; i++) {
            bazowe[i].setText(String.valueOf(values[i]));
        }
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
        int value;
        switch (textView.getId()) {
            case R.id.creator_input_ww_roll:
                addAndRefresh(R.id.creator_input_ww_base, textView, R.id.creator_input_ww_sum);
                break;
            case R.id.creator_input_us_roll:
                addAndRefresh(R.id.creator_input_us_base, textView, R.id.creator_input_us_sum);
                break;
            case R.id.creator_input_k_roll:
                addAndRefresh(R.id.creator_input_k_base, textView, R.id.creator_input_k_sum);
                break;
            case R.id.creator_input_odp_roll:
                addAndRefresh(R.id.creator_input_odp_base, textView, R.id.creator_input_odp_sum);
                break;
            case R.id.creator_input_zr_roll:
                addAndRefresh(R.id.creator_input_zr_base, textView, R.id.creator_input_zr_sum);
                break;
            case R.id.creator_input_int_roll:
                addAndRefresh(R.id.creator_input_int_base, textView, R.id.creator_input_int_sum);
                break;
            case R.id.creator_input_sw_roll:
                addAndRefresh(R.id.creator_input_sw_base, textView, R.id.creator_input_sw_sum);
                break;
            case R.id.creator_input_ogd_roll:
                addAndRefresh(R.id.creator_input_ogd_base, textView, R.id.creator_input_ogd_sum);
                break;
        }
    }

    private void addAndRefresh(int baseTextId, TextView rollText, int sumTextId) {
        int value = Integer.parseInt(String.valueOf(((TextInputEditText) findViewById(baseTextId)).getText()));
        try {
            value += Integer.parseInt(String.valueOf(rollText.getText()));
        } catch (NumberFormatException e) {
        }
        ((TextInputEditText) findViewById(sumTextId)).setText(String.valueOf(value));
    }

    static class CharacterDataPackage {
        public byte[] charakterystyki;
        public String imie;
        public String profesja;
        public String rasa;

        public CharacterDataPackage() {
            charakterystyki = new byte[16];
        }
    }
}
