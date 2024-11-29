package com.example.rockneco2.api

data class SpotifyResponse(
    val tracks: TrackResult
)

data class TrackResult(
    val items: List<Track>
)

data class Track(
    val id: String,
    val name: String,
    val artists: List<Artist>,
    val album: Album,
    val preview_url: String?
)

data class Artist(
    val name: String
)

data class Album(
    val name: String,
    val images: List<Image>
)

data class Image(
    val url: String
)

