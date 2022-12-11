package com.example.gotime_v05;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CategoryScreen extends AppCompatActivity {

    // creating variables for our array list,
    // db handler, adapter and recycler view.
    private ArrayList<TaskModal> courseModalArrayList;
    private DBHandler dbHandler;
    private CategoryRVAdapter categoryRVAdapter;
    private RecyclerView categoryRv;
    private FloatingActionButton fab;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_category);

        fab = findViewById(R.id.fabAddCategory);

        // initializing our all variables.
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(CategoryScreen.this);

        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        categoryRVAdapter = new CategoryRVAdapter(courseModalArrayList, CategoryScreen.this);
        categoryRv = findViewById(R.id.idRVCategory);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CategoryScreen.this, RecyclerView.VERTICAL, false);
        categoryRv.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        categoryRv.setAdapter(categoryRVAdapter);



        fab.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i;
                i = new Intent(CategoryScreen.this, AddTasks.class);
                startActivity(i);
            }
        });

    }
}
