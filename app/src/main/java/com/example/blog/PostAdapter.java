package com.example.blog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PostAdapter extends FirestoreRecyclerAdapter <Post, PostAdapter.PostHolder> {
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public PostAdapter(@NonNull FirestoreRecyclerOptions<Post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostHolder holder, int position, @NonNull Post model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewInhoud.setText(model.getInhoud());
        holder.textViewDatum.setText(dateFormat.format(model.getDatum()));
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts,
                parent, false);
        return new PostHolder(v);
    }

    class PostHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewInhoud;
        TextView textViewDatum;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewInhoud = itemView.findViewById(R.id.inhoud);
            textViewDatum = itemView.findViewById(R.id.datum);
        }
    }
}
