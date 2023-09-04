package com.example.gymapplicationfinalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.example.gymapplicationfinalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupClickListener()
    }

    private fun setupClickListener() {
        binding.abs.setOnClickListener {
        val openAbs = Intent(this@MainActivity, AbsScreen::class.java)
        startActivity(openAbs)
        }
        binding.leftBicep.setOnClickListener {
            val openBiceps = Intent(this@MainActivity, BicepsScreen::class.java)
            startActivity(openBiceps)
        }
        binding.rightBicep.setOnClickListener {
            val openBiceps = Intent(this@MainActivity, BicepsScreen::class.java)
            startActivity(openBiceps)
        }
        binding.pecs.setOnClickListener {
            val openPecs = Intent(this@MainActivity, ChestScreen::class.java)
            startActivity(openPecs)
        }
        binding.frontLeftShoulder.setOnClickListener {
            val openDelts = Intent(this@MainActivity, DeltoidsScreen::class.java)
            startActivity(openDelts)
        }
        binding.frontRightShoulder.setOnClickListener {
            val openDelts = Intent(this@MainActivity, DeltoidsScreen::class.java)
            startActivity(openDelts)
        }
        binding.backLeftShoulder.setOnClickListener {
            val openDelts = Intent(this@MainActivity, DeltoidsScreen::class.java)
            startActivity(openDelts)
        }
        binding.backRightShoulder.setOnClickListener {
            val openDelts = Intent(this@MainActivity, DeltoidsScreen::class.java)
            startActivity(openDelts)
        }
        binding.frontLeftForearm.setOnClickListener {
            val openForearms = Intent(this@MainActivity, ForearmsScreen::class.java)
            startActivity(openForearms)
        }
        binding.frontRightForearm.setOnClickListener {
            val openForearms = Intent(this@MainActivity, ForearmsScreen::class.java)
            startActivity(openForearms)
        }
        binding.backLeftForearm.setOnClickListener {
            val openForearms = Intent(this@MainActivity, ForearmsScreen::class.java)
            startActivity(openForearms)
        }
        binding.backRightForearm.setOnClickListener {
            val openForearms = Intent(this@MainActivity, ForearmsScreen::class.java)
            startActivity(openForearms)
        }
        binding.glutes.setOnClickListener {
            val openGlutes = Intent(this@MainActivity, GlutesScreen::class.java)
            startActivity(openGlutes)
        }
        binding.leftHamstring.setOnClickListener {
            val openHamstrings = Intent(this@MainActivity, HamstringsScreen::class.java)
            startActivity(openHamstrings)
        }
        binding.rightHamstring.setOnClickListener {
            val openHamstrings = Intent(this@MainActivity, HamstringsScreen::class.java)
            startActivity(openHamstrings)
        }
        binding.middleBack.setOnClickListener {
            val openMiddleBack = Intent(this@MainActivity, MiddleBackScreen::class.java)
            startActivity(openMiddleBack)
        }
        binding.leftOblique.setOnClickListener {
            val openObliques = Intent(this@MainActivity, ObliquesScreen::class.java)
            startActivity(openObliques)
        }
        binding.rightOblique.setOnClickListener {
            val openObliques = Intent(this@MainActivity, ObliquesScreen::class.java)
            startActivity(openObliques)
        }
        binding.leftTriceps.setOnClickListener {
            val openTriceps = Intent(this@MainActivity, TricepsScreen::class.java)
            startActivity(openTriceps)
        }
        binding.rightTriceps.setOnClickListener {
            val openTriceps = Intent(this@MainActivity, TricepsScreen::class.java)
            startActivity(openTriceps)
        }
        binding.upperBack.setOnClickListener {
            val openUpperBack = Intent(this@MainActivity, UpperBackScreen::class.java)
            startActivity(openUpperBack)
        }
        binding.leftTrapezius.setOnClickListener {
            val openTraps = Intent(this@MainActivity, TrapeziusScreen::class.java)
            startActivity(openTraps)
        }
        binding.rightTrapezius.setOnClickListener {
            val openTraps = Intent(this@MainActivity, TrapeziusScreen::class.java)
            startActivity(openTraps)
        }
        binding.LeftQuad.setOnClickListener {
            val openQuads = Intent(this@MainActivity, QuadricepsScreen::class.java)
            startActivity(openQuads)
        }
        binding.rightQuad.setOnClickListener {
            val openQuads = Intent(this@MainActivity, QuadricepsScreen::class.java)
            startActivity(openQuads)
        }
        binding.questionMark.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                R.string.help_button_clicked,
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.homepageButton.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                R.string.homepage_button_clicked,
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.workoutButton.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                R.string.workout_list_button_clicked,
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.userInfoButton.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                R.string.user_info_button_clicked,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}