package com.example.blog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchBarAdapter extends RecyclerView.Adapter<SearchBarAdapter.SearchViewHolder> {
    Context context;
    ArrayList<String> TitleList;

    class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public SearchBarAdapter(Context context, ArrayList<String> titleList) {
        this.context = context;
        TitleList = titleList;
    }

    @NonNull
    @Override
    public SearchBarAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.posts, parent, false);
        return new SearchBarAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.title.setText(TitleList.get(position));
    }

    @Override
    public int getItemCount() {
        return TitleList.size();
    }
}
