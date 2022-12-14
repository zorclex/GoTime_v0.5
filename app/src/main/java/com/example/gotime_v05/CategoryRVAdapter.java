package com.example.gotime_v05;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<TaskModal> courseModalArrayList;
    private Context context;

    // constructor
    public CategoryRVAdapter(ArrayList<TaskModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        TaskModal modal = courseModalArrayList.get(position);
        holder.courseTracksTV.setText(modal.getCourseTracks());
       // for(int x = 0; x < courseModalArrayList.size(); x++)
      //  {
       //     if(modal.getCourseTracks().equals(scrollTo))
       // }

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateCourseActivity.class);

                // below we are passing all our values.

                i.putExtra("Category", modal.getCourseTracks());

                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView courseTracksTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our text views
            courseTracksTV = itemView.findViewById(R.id.idTVCategory);
            //ArrayList with duplicates String

        }
    }

}
