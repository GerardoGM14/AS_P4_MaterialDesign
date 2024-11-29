package com.example.rockneco2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rockneco2.databinding.ActivityProfileBinding
import com.example.rockneco2.model.Profile

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadUserProfile()
    }

    private fun loadUserProfile() {
        val profile = Profile(
            userId = "1",
            userName = "John Doe",
            avatarUrl = "",
            bio = "Amante del anime y la música",
            totalPoints = 1000
        )

        binding.tvUserName.text = profile.userName
        binding.tvBio.text = profile.bio
        binding.tvTotalPoints.text = "${profile.totalPoints} puntos"
    }
}
