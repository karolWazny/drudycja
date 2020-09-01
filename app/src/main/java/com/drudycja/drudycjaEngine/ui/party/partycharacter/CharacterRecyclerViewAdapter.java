package com.drudycja.drudycjaEngine.ui.party.partycharacter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.party.partycharacter.character.CharacterDetailActivity;
import com.drudycja.drudycjaEngine.ui.party.partycharacter.character.CharacterItem;

import java.util.List;

public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterRecyclerViewAdapter.ViewHolder> {

    private final Fragment mParentFragment;
    private final List<CharacterItem> characterItems;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CharacterItem character = (CharacterItem) view.getTag();
            Context context = view.getContext();
            Intent intent = new Intent(view.getContext(), CharacterDetailActivity.class);
            intent.putExtra(CharacterDetailActivity.ARG_CHARACTER_ID, character.id);
            context.startActivity(intent);
        }
    };

    CharacterRecyclerViewAdapter(Fragment parent,
                                 List<CharacterItem> characterItems) {
        mParentFragment = parent;
        this.characterItems = characterItems;
    }

    @Override
    @NonNull
    public CharacterRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_character_item, parent, false);
        return new CharacterRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CharacterRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.nameView.setText(String.valueOf(characterItems.get(position).name));
        holder.raceProfessionView.setText(characterItems.get(position).race + " " +
                characterItems.get(position).profession);

        holder.itemView.setTag(characterItems.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return characterItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final TextView raceProfessionView;

        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.character_item_name);
            raceProfessionView = view.findViewById(R.id.character_item_race);
        }
    }
}