package com.example.gymapplicationfinalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymapplicationfinalproject.databinding.ActivityBicycleCrunchScreenBinding

class BicycleCrunchScreen : AppCompatActivity() {

    private lateinit var binding: ActivityBicycleCrunchScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bicycle_crunch_screen)

        binding = ActivityBicycleCrunchScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupClickListener()

    }

    private fun setupClickListener() {
        binding.backButton.setOnClickListener {
            val intent = Intent(this@BicycleCrunchScreen, AbsScreen::class.java)
            startActivity(intent)
        }
    }
}