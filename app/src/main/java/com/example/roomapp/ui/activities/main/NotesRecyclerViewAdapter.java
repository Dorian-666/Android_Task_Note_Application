package com.example.roomapp.ui.activities.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapp.R;
import com.example.roomapp.model.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesRecyclerViewAdapter extends RecyclerView.Adapter<NotesViewHolder> {

    private List<Note> notesList = new ArrayList<>();

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_note, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.bindItem(notesList.get(position));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public void submitList(List<Note> newNotesList) {
        notesList.clear();
        notesList.addAll(newNotesList);
        notifyDataSetChanged();
    }

}
