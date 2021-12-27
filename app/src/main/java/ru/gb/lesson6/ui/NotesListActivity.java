package ru.gb.lesson6.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.gb.lesson6.R;
import ru.gb.lesson6.data.Repo;

public class NotesListActivity extends AppCompatActivity {

    private Repo repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
    }
}