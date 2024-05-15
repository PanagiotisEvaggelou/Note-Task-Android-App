package com.mgiandia.library.view.Note.Search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mgiandia.library.R;
import com.mgiandia.library.domain.Note;

import java.util.List;

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder> {

    private final List<Note> mValues;
    private final ItemSelectionListener listener;

    public NoteRecyclerViewAdapter(List<Note> items,
                                   ItemSelectionListener listener) {
        mValues = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Note currentItem = mValues.get(position);
        holder.txtItemId.setText(String.valueOf(currentItem.getId()));
        holder.txtItemTitle.setText(currentItem.getTitle());
        holder.txtItemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.selectBook(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txtItemId;
        public final TextView txtItemTitle;

        public ViewHolder(View view) {
            super(view);
            txtItemId = view.findViewById(R.id.txt_item_id);
            txtItemTitle = view.findViewById(R.id.txt_item_title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtItemTitle.getText() + "'";
        }
    }

    public interface ItemSelectionListener {
        void selectBook(Note b);
    }
}