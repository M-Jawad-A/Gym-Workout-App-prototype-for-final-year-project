package com.example.gymapplicationfinalproject

import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapplicationfinalproject.databinding.ActivityBicepsScreenBinding
import com.example.gymapplicationfinalproject.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class BicepsScreen : AppCompatActivity(), ExerciseRVAdapter.OnItemClickListener {

    private lateinit var binding: ActivityBicepsScreenBinding

    // on below line we are creating variables for
    // our swipe to refresh layout, recycler view,
    // adapter and list.
    lateinit var bicepsRV: RecyclerView
    lateinit var bicepsExerciseRVAdapter: ExerciseRVAdapter
    lateinit var bicepsExerciseList: ArrayList<ExerciseRVTemplate>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biceps_screen)

        binding = ActivityBicepsScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupClickListener()

        // on below line we are initializing our views with their ids.
        bicepsRV = findViewById(R.id.idRVBicepsExercises)

        // on below line we are initializing our list
        bicepsExerciseList = ArrayList()

        // on below line we are initializing our adapter
        bicepsExerciseRVAdapter = ExerciseRVAdapter(bicepsExerciseList, this)

        // on below line we are setting adapter to our recycler view.
        bicepsRV.adapter = bicepsExerciseRVAdapter

        // on below line we are adding data to our list
        bicepsExerciseList.add(ExerciseRVTemplate("Biceps Curl", R.drawable.biceps_curl_dumbbell,
            "barbell, dumbbell, machine, smith machine, cable"))
        bicepsExerciseList.add(ExerciseRVTemplate("Concentration Curl", R.drawable.concentration_curls_dumbbell,
            "dumbbell, band, barbell, kettlebell"))
        bicepsExerciseList.add(ExerciseRVTemplate("Hammer Curl", R.drawable.hammer_curls_dumbbell,
            "dumbbell"))
        bicepsExerciseList.add(ExerciseRVTemplate("Drag Curls", R.drawable.drag_curls_barbell,
            "barbel, dumbbell, cable"))
        bicepsExerciseList.add(ExerciseRVTemplate("Preacher Curls", R.drawable.preacher_curl_dumbbell,
            "dumbbell, barbell, cable"))

        // on below line we are notifying adapter
        // that data has been updated.
        bicepsExerciseRVAdapter.notifyDataSetChanged()
    }

    // calling on create option menu
    // layout to inflate our menu file.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // below line is to get our inflater
        val inflater = menuInflater

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_exercise, menu)

        // below line is to get our menu item.
        val searchItem: MenuItem = menu.findItem(R.id.exerciseSearch)

        // getting search view of our item.
        val searchView: SearchView = searchItem.getActionView() as SearchView

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(msg)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<ExerciseRVTemplate> = ArrayList()

        // running a for loop to compare elements.
        for (item in bicepsExerciseList) {
            if (item.exerciseName.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            bicepsExerciseRVAdapter.filterList(filteredlist)
        }
    }
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position chlicked", Toast.LENGTH_SHORT).show()
        //11:48 mins in
    }

    private fun setupClickListener() {
        binding.backButton.setOnClickListener {
            val intent = Intent(this@BicepsScreen, MainActivity::class.java)
            startActivity(intent)
        }
    }
}