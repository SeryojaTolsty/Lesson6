package ru.gb.lesson6.Recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.lesson6.R;
import ru.gb.lesson6.data.Note;
import ru.gb.lesson6.ui.NotesListActivity;

public class NoteHolder extends RecyclerView.ViewHolder {



    private TextView title;
    private TextView description;
    private Note note;


    public NoteHolder(@NonNull View itemView, NotesAdapter.OnClickNoteListener listener) {
        super(itemView);

        title = itemView.findViewById(R.id.note_title);
        description = itemView.findViewById(R.id.note_description);

        itemView.setOnClickListener(view -> listener.onClickNote(note));
    }

    void bind(Note note) {
        this.note = note;

        title.setText(note.getTitle());
        description.setText(note.getDescription());
    }
}
