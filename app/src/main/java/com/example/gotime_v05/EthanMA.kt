package com.example.gotime_v05;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.todolisttutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewTaskSheet().show(supportFragmentManager, "newTaskTag")
        }
        taskViewModel.name.observe(this){
            binding.taskName.text = String.format("Task name: %s", it)
        }
        taskViewModel.desc.observe(this){
            binding.taskDescription.text = String.format("Task Desc: %s", it)
        }
    }
}