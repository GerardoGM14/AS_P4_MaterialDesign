package com.example.rockneco2.model

data class Profile(
    val userId: String,
    val userName: String,
    val avatarUrl: String,
    val bio: String,
    val totalPoints: Int
)
