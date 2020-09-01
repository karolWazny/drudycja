package com.drudycja.drudycjaEngine.ui.battle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;

import java.util.List;

public class BattleCharacterAdapter extends RecyclerView.Adapter<BattleCharacterAdapter.ViewHolder> {

    private final Fragment parent;
    private final List<CharacterInBattleItem> characters;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //todo implement refreshing actions and full details in bottom pager
        }
    };

    public BattleCharacterAdapter(Fragment parent, List<CharacterInBattleItem> characters) {
        this.parent = parent;
        this.characters = characters;
    }

    @NonNull
    @Override
    public BattleCharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_character_item, parent, false);
        return new BattleCharacterAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BattleCharacterAdapter.ViewHolder holder, int position) {
        holder.nameView.setText(characters.get(position).getName());
        holder.shortDetailsView.setText(characters.get(position).getDetails());
        holder.itemView.setTag(characters.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final TextView shortDetailsView;

        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.character_item_name);
            shortDetailsView = view.findViewById(R.id.character_item_race);
        }
    }
}
