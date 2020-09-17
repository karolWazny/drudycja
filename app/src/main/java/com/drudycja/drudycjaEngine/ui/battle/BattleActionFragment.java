package com.drudycja.drudycjaEngine.ui.battle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.walka.Battle;

public class BattleActionFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Battle battle;
    private BattleActivity parent;
    private Spinner raceSpinner;
    private Spinner targetSpinner;

    public BattleActionFragment(BattleActivity parent) {
        this.parent = parent;
        this.battle = parent.getBattle();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle_action, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.battle_characters_recycler);
        assert recyclerView != null;
        setupSpinners(view);
    }

    private void setupSpinners(View view) {
        setupActionSpinner(view);
        setupTargetSpinner(view);
    }

    private void setupActionSpinner(View view) {
        raceSpinner = view.findViewById(R.id.action_spinner);
        ArrayAdapter<CharSequence> raceSpinnerAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.races_array,
                android.R.layout.simple_spinner_item);
        raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceSpinner.setAdapter(raceSpinnerAdapter);
        raceSpinner.setOnItemSelectedListener(this);
    }

    private void setupTargetSpinner(View view) {
        targetSpinner = view.findViewById(R.id.target_spinner);
        ArrayAdapter<CharSequence> raceSpinnerAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.races_array,
                android.R.layout.simple_spinner_item);
        raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        targetSpinner.setAdapter(raceSpinnerAdapter);
        targetSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
