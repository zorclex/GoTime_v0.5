package com.example.gotime_v05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // creating variables for our array list,
    // db handler, adapter and recycler view.
    private ArrayList<TaskModal> taskModalArrayList;
    private DBHandler dbHandler;
    private CourseRVAdapter tasksRVAdapter;
    private RecyclerView tasksRV;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fab = findViewById(R.id.fabAddCategory);

        setContentView(R.layout.activity_view_courses);

        // initializing our all variables.
        taskModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(MainActivity.this);

        // getting our course array
        // list from db handler class.
        taskModalArrayList = dbHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        tasksRVAdapter = new CourseRVAdapter(taskModalArrayList, MainActivity.this);
        tasksRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        tasksRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        tasksRV.setAdapter(tasksRVAdapter);



        fab.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i;
                i = new Intent(MainActivity.this, AddTasks.class);
                startActivity(i);
            }
        });

    }
}
