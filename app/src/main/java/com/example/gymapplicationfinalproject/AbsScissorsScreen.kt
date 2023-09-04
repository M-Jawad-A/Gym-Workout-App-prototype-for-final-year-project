package com.example.gymapplicationfinalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymapplicationfinalproject.databinding.ActivityAbsScissorsScreenBinding

class AbsScissorsScreen : AppCompatActivity() {

    private lateinit var binding: ActivityAbsScissorsScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abs_scissors_screen)

        binding = ActivityAbsScissorsScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupClickListener()

    }

    private fun setupClickListener() {
        binding.backButtonAbsScissors.setOnClickListener {
            val intent = Intent(this@AbsScissorsScreen, AbsScreen::class.java)
            startActivity(intent)
        }
    }
}