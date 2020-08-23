package com.drudycja.drudycjaEngine.ui.partycharacter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.drudycja.R;
import com.drudycja.drudycjaEngine.ui.PartyFragment;
import com.drudycja.drudycjaEngine.ui.partycharacter.dummy.DummyContent;

import java.util.List;

import static com.drudycja.R.id.new_character_button;
import static com.drudycja.R.string;

public class PartyCharacterFragment extends PartyFragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    public static ItemFragment newInstance(int columnCount) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        buttonId = new_character_button;
        layoutId = R.layout.fragment_party_character;
        View view = super.onCreateView(inflater, container, savedInstanceState);
        //z drugiego projektu:
        View recyclerView = view.findViewById(R.id.character_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case new_character_button:
                openNewCharacterDialog();
                break;
        }
    }

    private void openNewCharacterDialog() {
        new AlertDialog.Builder(getContext())
                .setTitle(string.title_new_character)
                .setItems(R.array.nowa_postac,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //uruchomGre(i);
                            }
                        })
                .show();
    }

    //z drugiego projektu:
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleCharacterRecyclerViewAdapter(this, DummyContent.ITEMS));
    }

    public static class SimpleCharacterRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleCharacterRecyclerViewAdapter.ViewHolder> {

        private final Fragment mParentFragment;
        private final List<DummyContent.DummyItem> mValues;
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

        SimpleCharacterRecyclerViewAdapter(Fragment parent,
                                           List<DummyContent.DummyItem> items) {
            mValues = items;
            mParentFragment = parent;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
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
}
