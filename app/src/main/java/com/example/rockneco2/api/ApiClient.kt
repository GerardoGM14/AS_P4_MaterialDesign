package com.example.rockneco2.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val BASE_URL_SPOTIFY = "https://api.spotify.com/v1/"
    private const val BASE_URL_ANIME = "https://anime-db.p.rapidapi.com/" // Cambiado con la URL correcta para RapidAPI

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    // Método genérico para crear Retrofit con una base URL
    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Retrofit para Spotify
    val spotifyApi: Retrofit = createRetrofit(BASE_URL_SPOTIFY)

    // Retrofit para Anime
    val animeApi: Retrofit = createRetrofit(BASE_URL_ANIME)
}

