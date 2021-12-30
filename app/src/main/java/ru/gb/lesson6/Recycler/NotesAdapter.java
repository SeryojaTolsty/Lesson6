package ru.gb.lesson6.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import ru.gb.lesson6.R;
import ru.gb.lesson6.Recycler.NoteHolder;
import ru.gb.lesson6.data.Note;

public class NotesAdapter extends RecyclerView.Adapter<NoteHolder> {
    private final ArrayList<Note> notes = new ArrayList<>();
    private OnClickNoteListener onClickNoteListener;

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(view, onClickNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.bind(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(ArrayList<Note> newNotes) {
        this.notes.clear();
        this.notes.addAll(newNotes);
        notifyDataSetChanged();
    }

    public void setOnClickNoteListener(OnClickNoteListener onClickNoteListener) {
        this.onClickNoteListener = onClickNoteListener;
    }

    public interface OnClickNoteListener {
        void onClickNote(Note note);
    }
}