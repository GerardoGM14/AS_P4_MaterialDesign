package com.example.rockneco2.model

data class Course(
    val id: Int,
    val title: String,
    val description: String,
    val progress: Int, // Representa el progreso como porcentaje
    val imageUrl: String
)
