package com.example.rockneco2.api

data class AnimeResponse(
    val data: List<Anime>,
    val currentPage: Int,
    val totalPages: Int
)

data class Anime(
    val id: String,
    val title: String,
    val alternativeTitles: List<String>?,
    val ranking: Int?,
    val genres: List<String>?,
    val episodes: Int?,
    val image: String?,
    val synopsis: String?,
    val link: String?,
    val status: String?
)

data class Meta(
    val currentPage: Int,
    val pageCount: Int,
    val itemCount: Int
)

