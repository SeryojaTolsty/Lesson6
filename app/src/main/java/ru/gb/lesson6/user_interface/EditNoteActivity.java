package ru.gb.lesson6.user_interface;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import ru.gb.lesson6.R;
import ru.gb.lesson6.data.Constants;
import ru.gb.lesson6.data.InMemoryRepoImpl;
import ru.gb.lesson6.data.Note;
import ru.gb.lesson6.data.Repo;

public class EditNoteActivity extends AppCompatActivity {

    private Repo repository = InMemoryRepoImpl.getIstance();
    private EditText title;
    private EditText description;
    private Button saveNote;
    private int id = -1;

    private Note note;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        title = findViewById(R.id.edit_note_title);
        description = findViewById(R.id.edit_note_description);
        saveNote = findViewById(R.id.edit_note_update);




        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(NotesListActivity.NOTE_NEW)) {
            Note note = (Note) intent.getSerializableExtra(Constants.NOTE);
            id = note.getId();
            title.setText(note.getTitle());
            description.setText(note.getDescription());
        }
        //
        else {
            note = new Note("", "");
        }

        title.setText(note.getTitle());
        description.setText(note.getDescription());

        saveNote.setOnClickListener(view -> {
            String title = this.title.getText().toString();
            note.setTitle(title);

            String description = this.description.getText().toString();
            note.setDescription(description);
            if (note.getId() == null) {
                this.repository.create(note);
            } else {
                this.repository.update(note);
            }
            finish();
        });
    }
}
