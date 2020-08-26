package com.drudycja.drudycjaEngine.ui.partycharacter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.database.MyDatabaseHelper;
import com.drudycja.drudycjaEngine.ui.partycharacter.dummy.DummyContent;
import com.drudycja.drudycjaEngine.ui.partycharacter.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterRecyclerViewAdapter.ViewHolder> {

    private final Fragment mParentFragment;
    private final MyDatabaseHelper myDatabaseHelper;
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

    CharacterRecyclerViewAdapter(Fragment parent,
                                 MyDatabaseHelper myDatabaseHelper) {
        this.myDatabaseHelper = myDatabaseHelper;
        mParentFragment = parent;
    }

    @Override
    public CharacterRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new CharacterRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CharacterRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.itemView.setTag(mValues.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
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