package com.example.roomapp.ui.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapp.AddNoteActivity;
import com.example.roomapp.R;
import com.example.roomapp.local.AppDatabase;
import com.example.roomapp.local.dao.NotesDao;
import com.example.roomapp.model.entity.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NotesDao notesDao;
    private Note note;
    private NavController navController;

    private RecyclerView recyclerViewNotes;
    private Button buttonAddNote;

    private NotesRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindUI();
        setListeners();
        configureDatabase();
        configureRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Note> fetchedNotesListFromDatabase = notesDao.getAll();
        adapter.submitList(fetchedNotesListFromDatabase);
    }

    private void bindUI() {
        recyclerViewNotes = findViewById(R.id.recycler_view_notes);
        buttonAddNote = findViewById(R.id.button_add_note);
    }

    private void setListeners() {

        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToAddNoteActivity();
            }
        });

    }

    private void configureDatabase() {
        AppDatabase appDatabase = AppDatabase.getDatabase(getApplicationContext());
        this.notesDao = appDatabase.getNotesDao();
    }

    private void configureRecyclerView() {
        adapter = new NotesRecyclerViewAdapter();
        recyclerViewNotes.setAdapter(adapter);
    }

    private void navigateToAddNoteActivity() {
        //TODO create an intent for navigating from MainActivity to AddNoteActivity which you will create
        //TODO AddNoteActivity uses method of NotesDao (Insert a note method) and save to database
        //TODO after addition process, you must finish AddNoteActivity
        Intent i = new Intent(this, AddNoteActivity.class);
        startActivity(i);
    }

}