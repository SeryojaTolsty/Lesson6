package ru.gb.lesson6.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;

import ru.gb.lesson6.R;
import ru.gb.lesson6.Recycler.NotesAdapter;
import ru.gb.lesson6.data.Constants;
import ru.gb.lesson6.data.CreateNewConstants;
import ru.gb.lesson6.data.InMemoryRepoImpl;
import ru.gb.lesson6.data.Note;
import ru.gb.lesson6.data.Repo;

public class NotesListActivity extends AppCompatActivity implements NotesAdapter.OnClickNoteListener {
    public static final String NOTE_NEW = "NOTE_NEW";

    //    private Repo repository = new InMemoryRepoImpl();
    private Repo repository = InMemoryRepoImpl.getIstance();
    private RecyclerView rvList;
    private NotesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        fillRepo();

        adapter = new NotesAdapter();
//        adapter.setNotes(repository.getAll());
        adapter.setOnClickNoteListener(this);


        rvList = findViewById(R.id.list);
//        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));//для того, чтобы скроллить в стороны (редко применяется) - горизонтальная ориентация
        rvList.setLayoutManager(new LinearLayoutManager(this));  //вертикальная ориентация
        rvList.setAdapter(adapter);


    }

    private void fillRepo() {
        repository.create(new Note("Title 1", "Description 1"));
        repository.create(new Note("Title 2", "Description 2"));
        repository.create(new Note("Title 3", "Description 3"));
        repository.create(new Note("Title 4", "Description 4"));
        repository.create(new Note("Title 5", "Description 5"));
        repository.create(new Note("Title 6", "Description 6"));
        repository.create(new Note("Title 7", "Description 7"));
        repository.create(new Note("Title 8", "Description 8"));
        repository.create(new Note("Title 9", "Description 9"));
        repository.create(new Note("Title 10", "Description 10"));
        repository.create(new Note("Title 11", "Description 11"));
        repository.create(new Note("Title 12", "Description 12"));
        repository.create(new Note("Title 13", "Description 13"));
        repository.create(new Note("Title 14", "Description 14"));
        repository.create(new Note("Title 15", "Description 15"));
        repository.create(new Note("Title 16", "Description 16"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_create:
                // TODO создать интент
                Intent createIntent = new Intent(this, NewNoteActivity.class);
                createIntent.putExtra(CreateNewConstants.NEW_NOTE, -1);
                startActivity(createIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickNote(Note note) {
        Intent editIntent = new Intent(this, EditNoteActivity.class);
        editIntent.putExtra(NOTE_NEW, note);
        startActivity(editIntent);
    }

    @Override
    public void onNoteClick(Note note) {
        Intent intent = new Intent(this, EditNoteActivity.class);
        intent.putExtra(Constants.NOTE, note);
        startActivity(intent);
    }
}