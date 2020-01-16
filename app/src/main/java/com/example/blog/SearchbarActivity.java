package com.example.blog;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchbarActivity extends AppCompatActivity {
    EditText search;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayList<String> TitleList;
    SearchBarAdapter searchBarAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        search = findViewById(R.id.search);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        TitleList = new ArrayList<>();

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    setAdapter(s.toString());
                } else {
                    TitleList.clear();
                    recyclerView.removeAllViews();
                }
            }
        });
    }

    private void setAdapter(final String searchedString) {

        databaseReference.child("title").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String uid = snapshot.getKey();
                    String title = snapshot.child("title").getValue(String.class);

                    if (title.toLowerCase().contains(searchedString.toLowerCase())){
                        TitleList.add(title);
                    }
                }
                searchBarAdapter = new SearchBarAdapter(SearchbarActivity.this, TitleList);
                recyclerView.setAdapter(searchBarAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
