package com.example.gymapplicationfinalproject

import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapplicationfinalproject.databinding.ActivityAbsScreenBinding
import com.example.gymapplicationfinalproject.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class AbsScreen : AppCompatActivity(), ExerciseRVAdapter.OnItemClickListener {

    private lateinit var binding: ActivityAbsScreenBinding

    // on below line we are creating variables for
    // our swipe to refresh layout, recycler view,
    // adapter and list.
    lateinit var absRV: RecyclerView
    lateinit var absExerciseRVAdapter: ExerciseRVAdapter
    lateinit var absExerciseList: ArrayList<ExerciseRVTemplate>
    //lateinit var filteredlist: ArrayList<ExerciseRVTemplate>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abs_screen)

        binding = ActivityAbsScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupClickListener()

        // on below line we are initializing our views with their ids.
        absRV = findViewById(R.id.idRVAbsExercises)

        // on below line we are initializing our list
        absExerciseList = ArrayList()

        // on below line we are initializing our adapter
        absExerciseRVAdapter = ExerciseRVAdapter(absExerciseList, this)

        // on below line we are setting adapter to our recycler view.
        absRV.adapter = absExerciseRVAdapter

        // on below line we are adding data to our list
        absExerciseList.add(ExerciseRVTemplate("Ab scissors", R.drawable.ab_scissors, "Calisthenics"))
        absExerciseList.add(ExerciseRVTemplate("Bicycle crunch", R.drawable.bicycle_crunch, "Calisthenics, band"))
        absExerciseList.add(ExerciseRVTemplate("Crossbody crunches", R.drawable.crossbody_crunch, "Calisthenics"))
        absExerciseList.add(ExerciseRVTemplate("Mountain climber", R.drawable.mountain_climber, "Calisthenics"))
        absExerciseList.add(ExerciseRVTemplate("V ups", R.drawable.v_ups, "Calisthenics, band"))

        // on below line we are notifying adapter
        // that data has been updated.
        absExerciseRVAdapter.notifyDataSetChanged()

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
        //filteredlist = ArrayList()

        // running a for loop to compare elements.
        for (item in absExerciseList) {
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
            absExerciseRVAdapter.filterList(filteredlist)
        }

    }

    override fun onItemClick(position: Int) {
        if (absExerciseList[position].exerciseName == "Ab scissors") {
            val intent = Intent(this@AbsScreen, AbsScissorsTabs::class.java)
            startActivity(intent)
        }
        else if (absExerciseList[position].exerciseName == "Bicycle crunch") {
            val intent = Intent(this@AbsScreen, BicycleCrunchScreen::class.java)
            startActivity(intent)
        }
        else if (absExerciseList[position].exerciseName == "Crossbody crunches") {
            val intent = Intent(this@AbsScreen, AbsScissorsTabs::class.java)
            startActivity(intent)
        }
        else if (absExerciseList[position].exerciseName == "Mountain climber") {
            val intent = Intent(this@AbsScreen, BicycleCrunchScreen::class.java)
            startActivity(intent)
        }
        else if (absExerciseList[position].exerciseName == "V ups") {
            val intent = Intent(this@AbsScreen, BicycleCrunchScreen::class.java)
            startActivity(intent)
        }
    }

    private fun setupClickListener() {
        binding.backButton.setOnClickListener {
            val intent = Intent(this@AbsScreen, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

