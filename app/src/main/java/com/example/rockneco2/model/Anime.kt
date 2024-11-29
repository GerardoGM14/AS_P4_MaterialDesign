package com.example.rockneco2.model

data class Anime(
    val id: String,
    val title: String,
    val image: String,
    val synopsis: String,
    val genres: List<String>,
    val rating: Double
)
