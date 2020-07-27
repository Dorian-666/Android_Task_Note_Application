package com.example.roomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomapp.local.AppDatabase;
import com.example.roomapp.local.dao.NotesDao;
import com.example.roomapp.model.entity.Note;

import java.util.UUID;

public class AddNoteActivity extends AppCompatActivity {
    private EditText title,description;
    private Button buttonSave;
    private NotesDao notesDao;
    private Note note ;
    private AppDatabase databaseOfNote;


    public AddNoteActivity(EditText title, EditText description, Button buttonSave, NotesDao notesDao, Note note, AppDatabase databaseOfNote) {
        this.title = title;
        this.description = description;
        this.buttonSave = buttonSave;
        this.notesDao = notesDao;
        this.note = note;
        this.databaseOfNote = databaseOfNote;
        UUID.randomUUID().toString();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        bindUi();;
        configureDatabase();
        setListeners();
        saveNoteToDatabase();


    }
    private void bindUi(){
        setContentView(R.layout.activity_add_note);
        buttonSave= findViewById(R.id.button_save);
        title = findViewById(R.id.edit_text_title);
        description = findViewById(R.id.edit_text_description);
        databaseOfNote = AppDatabase.getDatabase(AddNoteActivity.this);




    }
    private void configureDatabase() {
        AppDatabase appDatabase = AppDatabase.getDatabase(getApplicationContext());
        this.notesDao = appDatabase.getNotesDao();
    }
    private void setListeners(){
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note = new Note(UUID.randomUUID().toString(),
                        title.getText().toString(),
                        description.getText().toString());


            }
        });

    }

    private void saveNoteToDatabase(){
        notesDao.insert(note);
        finish();


    }

}