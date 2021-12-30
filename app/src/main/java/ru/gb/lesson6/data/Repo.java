package ru.gb.lesson6.data;

import java.util.List;

public interface Repo {

    //CRUD - Create Read Update Delete
    //----------чтобы сохранить данные интерфейса, нужно пройти все 4 этапа CRUD
    //Create
    //Read
    //Update
    //Delete

    int create(Note note);
    Note read(int id);
    void update(Note note);
    void delete(int id);

    List<Note> getAll();
}
