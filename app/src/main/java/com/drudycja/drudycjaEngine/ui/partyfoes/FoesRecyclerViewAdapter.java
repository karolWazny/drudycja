package com.drudycja.drudycjaEngine.ui.partyfoes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.partycharacter.character.CharacterItem;

import java.util.List;

public class FoesRecyclerViewAdapter extends RecyclerView.Adapter<FoesRecyclerViewAdapter.ViewHolder> {

    private final Fragment mParentFragment;
    private final List<CharacterItem> foesList;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                /*DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
                Context context = view.getContext();
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);

                context.startActivity(intent);*/
        }
    };

    FoesRecyclerViewAdapter(Fragment parent,
                            List<CharacterItem> foesList) {
        this.foesList = foesList;
        mParentFragment = parent;
    }

    @Override
    public FoesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new FoesRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FoesRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mIdView.setText(foesList.get(position).id);
        holder.mContentView.setText(foesList.get(position).name);

        holder.itemView.setTag(foesList.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return foesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mIdView;
        final TextView mContentView;

        ViewHolder(View view) {
            super(view);
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }
}