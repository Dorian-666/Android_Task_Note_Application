package com.example.roomapp.ui.activities.main;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapp.R;
import com.example.roomapp.model.entity.Note;

public class NotesViewHolder extends RecyclerView.ViewHolder {

    private TextView title, description;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.text_view_title);
        description = itemView.findViewById(R.id.text_view_description);
    }

    public void bindItem(Note note) {
        title.setText(note.getTitle());
        description.setText(note.getDescription());
    }

}
