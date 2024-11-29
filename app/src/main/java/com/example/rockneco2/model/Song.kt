package com.example.rockneco2.model

data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val album: String,
    val imageUrl: String,
    val previewUrl: String? // Enlace para reproducir un fragmento de la canción
)
