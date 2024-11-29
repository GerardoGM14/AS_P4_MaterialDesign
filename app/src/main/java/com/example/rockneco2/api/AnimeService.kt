package com.example.rockneco2.api

import com.example.rockneco2.model.Anime

class AnimeService(private val api: AnimeApiService) {
    suspend fun fetchAnimes(
        page: Int = 1,
        size: Int = 10,
        search: String? = null,
        sortBy: String? = null,
        sortOrder: String? = null,
        genres: String? = null
    ): List<Anime>? {
        return try {
            val response = api.getAllAnimes(page, size, search, sortBy, sortOrder, genres)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

