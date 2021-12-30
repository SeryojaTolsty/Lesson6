package ru.gb.lesson6.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import ru.gb.lesson6.R;
import ru.gb.lesson6.data.Constants;
import ru.gb.lesson6.data.Note;

public class NewNoteActivity extends AppCompatActivity {

    private EditText newTitle;
    private EditText newDescription;
    private Button newSaveNote;
    private int newId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        newTitle = findViewById(R.id.new_note_title);
        newDescription = findViewById(R.id.new_note_description);
        newSaveNote = findViewById(R.id.new_note_update);

        Intent intent = getIntent();
        if (intent != null) {
            Note note = (Note) intent.getSerializableExtra(Constants.NOTE);
            newId = note.getId();
            newTitle.setText(note.getTitle());
            newDescription.setText(note.getDescription());

        }
    }
}