package com.example.roomapp.ui.activities.addnote;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomapp.R;
import com.example.roomapp.local.AppDatabase;
import com.example.roomapp.local.dao.NotesDao;
import com.example.roomapp.model.entity.Note;

import java.util.UUID;

public class AddNoteActivity extends AppCompatActivity {
    private EditText title, description;
    private Button buttonSave;
    private NotesDao notesDao;
    public static boolean resultForValidation = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        bindUi();
        configureDatabase();
        setListeners();


    }

    private void bindUi() {
        buttonSave = findViewById(R.id.button_save);
        title = findViewById(R.id.edit_text_title);
        description = findViewById(R.id.edit_text_description);


    }

    private void configureDatabase() {
        AppDatabase appDatabase = AppDatabase.getDatabase(getApplicationContext());
        this.notesDao = appDatabase.getNotesDao();
    }

    private void setListeners() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validationOfTexts();
                if (resultForValidation == true) {
                    Note note = new Note(UUID.randomUUID().toString(),
                            title.getText().toString(),
                            description.getText().toString());
                    notesDao.insert(note);
                    finish();
                }


            }
        });

    }

    private Boolean validationOfTexts() {
        String titleForCheck = title.getText().toString();
        String descriptionForCheck = description.getText().toString();
        while (true) {
            if (TextUtils.isEmpty(titleForCheck) || (TextUtils.isEmpty(descriptionForCheck))){
                resultForValidation = false;
                Toast.makeText(this, "Title or description should not be empty! ", Toast.LENGTH_SHORT).show();

            } else if (resultForValidation == true) {
                break;
            }
        }
        return resultForValidation;


    }


}