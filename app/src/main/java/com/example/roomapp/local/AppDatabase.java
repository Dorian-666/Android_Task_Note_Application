package com.example.roomapp.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomapp.local.dao.NotesDao;
import com.example.roomapp.model.entity.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "AppDatabase";

    private static AppDatabase instance;

    public static AppDatabase getDatabase(Context context) {
        synchronized (AppDatabase.class) {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries() //NOT RECOMMENDED BUT IT IS NEEDED FOR NOW
                        .build();
            }
            return instance;
        }
    }

    public abstract NotesDao getNotesDao();

}
