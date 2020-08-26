package com.drudycja.drudycjaEngine.ui.partyparty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;

public class PartyRecyclerViewAdapter extends RecyclerView.Adapter<PartyRecyclerViewAdapter.ViewHolder> {

    private final Fragment mParentFragment;
    //private final List<DummyContent.DummyItem> mValues;
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

    PartyRecyclerViewAdapter(Fragment parent
            /*List<DummyContent.DummyItem> items*/) {
        /*mValues = items;*/
        mParentFragment = parent;
    }

    @Override
    public PartyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new PartyRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PartyRecyclerViewAdapter.ViewHolder holder, int position) {
       /* holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.itemView.setTag(mValues.get(position));*/
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return 0;
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