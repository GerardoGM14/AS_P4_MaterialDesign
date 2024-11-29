package com.example.rockneco2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rockneco2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMusic.setOnClickListener {
            startActivity(Intent(this, MusicActivity::class.java))
        }

        binding.btnAnime.setOnClickListener {
            startActivity(Intent(this, AnimeActivity::class.java))
        }

        binding.btnCourses.setOnClickListener {
            startActivity(Intent(this, CoursesActivity::class.java))
        }

        binding.btnRewards.setOnClickListener {
            startActivity(Intent(this, RewardsActivity::class.java))
        }

        binding.btnGoals.setOnClickListener {
            startActivity(Intent(this, GoalsActivity::class.java))
        }

        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
