package com.example.first_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<ModelClass> usersModelClasses = databaseHelperClass.getUserList();

        if (usersModelClasses.size() > 0){
            Adapter usersAdapterclass = new Adapter(usersModelClasses,ViewActivity.this);
            recyclerView.setAdapter(usersAdapterclass);
        }else {
            Toast.makeText(this, "There is no users in the database", Toast.LENGTH_SHORT).show();
        }

    }
    }
