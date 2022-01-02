package ru.gb.lesson6.data;

import java.util.ArrayList;

public class NotesRepo implements Repo {
    private final ArrayList<Note> notes = new ArrayList<>();
    private int counter;

    private static NotesRepo instance;

    public static NotesRepo getInstance() {
        if (instance == null) {
            instance = new NotesRepo();
        }

        return instance;
    }

    private NotesRepo(){}

    @Override
    public int create(Note note) {
        int id = ++counter;
        note.setId(id);
        notes.add(note);
        return id;
    }

    @Override
    public Note read(int id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }

        return null;
    }

    @Override
    public void update(Note note) {
        for (Note n : notes) {
            if (n.getId().equals(note.getId())) {
                n.setTitle(note.getTitle());
                n.setDescription(note.getDescription());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                notes.remove(notes.get(i));
                break;
            }
        }
    }

    @Override
    public ArrayList<Note> getAll() {
        return notes;
    }
}