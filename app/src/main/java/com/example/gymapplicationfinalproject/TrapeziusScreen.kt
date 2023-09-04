package com.example.gymapplicationfinalproject

import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapplicationfinalproject.databinding.ActivityTrapeziusScreenBinding
import com.example.gymapplicationfinalproject.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class TrapeziusScreen : AppCompatActivity(), ExerciseRVAdapter.OnItemClickListener {

    private lateinit var binding: ActivityTrapeziusScreenBinding

    // on below line we are creating variables for
    // our swipe to refresh layout, recycler view,
    // adapter and list.
    lateinit var trapsRV: RecyclerView
    lateinit var trapsExerciseRVAdapter: ExerciseRVAdapter
    lateinit var trapsExerciseList: ArrayList<ExerciseRVTemplate>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trapezius_screen)

        binding = ActivityTrapeziusScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupClickListener()

        // on below line we are initializing our views with their ids.
        trapsRV = findViewById(R.id.idRVTrapeziusExercises)

        // on below line we are initializing our list
        trapsExerciseList = ArrayList()

        // on below line we are initializing our adapter
        trapsExerciseRVAdapter = ExerciseRVAdapter(trapsExerciseList, this)

        // on below line we are setting adapter to our recycler view.
        trapsRV.adapter = trapsExerciseRVAdapter

        // on below line we are adding data to our list
        trapsExerciseList.add(ExerciseRVTemplate("Upright Row", R.drawable.upright_row, "Barbell"))
        trapsExerciseList.add(ExerciseRVTemplate("Rows", R.drawable.rows, "Cable, dumbbell, machine"))
        trapsExerciseList.add(ExerciseRVTemplate("Shrug", R.drawable.shrugs,
            "Barbell, dumbbell, cable, smith machine, machine"))
        trapsExerciseList.add(ExerciseRVTemplate("Around the world", R.drawable.around_the_world,
            "Dumbbell, kettlebell, plates"))
        trapsExerciseList.add(ExerciseRVTemplate("Lat pulldown", R.drawable.lat_pulldown, "Cable, machine, band"))

        // on below line we are notifying adapter
        // that data has been updated.
        trapsExerciseRVAdapter.notifyDataSetChanged()
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
        for (item in trapsExerciseList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.exerciseName.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))) {
                // if the item is matched we are
                // adding it to our filtered list.
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
            trapsExerciseRVAdapter.filterList(filteredlist)
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position chlicked", Toast.LENGTH_SHORT).show()
        //11:48 mins in
    }


    private fun setupClickListener() {
        binding.backButton.setOnClickListener {
            val intent = Intent(this@TrapeziusScreen, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
