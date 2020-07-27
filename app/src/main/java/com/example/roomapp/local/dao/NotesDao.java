package com.example.roomapp.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomapp.model.entity.Note;

import java.util.List;

@Dao
public interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Note note);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Note> notes);

    @Query("select * from notes")
    List<Note> getAll();

    @Query("delete from notes")
    void deleteAll();

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

}
