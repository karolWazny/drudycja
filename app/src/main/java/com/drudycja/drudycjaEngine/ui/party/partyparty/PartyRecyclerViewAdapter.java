package com.drudycja.drudycjaEngine.ui.party.partyparty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.database.party.PartyItem;

import java.util.List;

public class PartyRecyclerViewAdapter extends RecyclerView.Adapter<PartyRecyclerViewAdapter.ViewHolder> {

    private final Fragment mParentFragment;
    private final List<PartyItem> parties;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /*PartyItem partyItem = (PartyItem) view.getTag();
            Context context = view.getContext();
            Intent intent = new Intent(context, PartyDetailActivity.class);
            //todo dodatkowy argument w postaci partyItem, napisanie klasy jw
            context.startActivity(intent);*/
        }
    };

    PartyRecyclerViewAdapter(Fragment parent, List<PartyItem> parties) {
        mParentFragment = parent;
        this.parties = parties;
    }

    @Override
    public PartyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_character_item, parent, false);
        return new PartyRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PartyRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.name.setText(parties.get(position).name);

        holder.itemView.setTag(parties.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return parties.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;

        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.character_item_name);
        }
    }
}