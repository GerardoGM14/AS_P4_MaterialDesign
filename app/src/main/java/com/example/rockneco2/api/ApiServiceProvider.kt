package com.example.rockneco2.api

object ApiServiceProvider {
    val spotifyService: SpotifyService = ApiClient.spotifyApi.create(SpotifyService::class.java)
    val animeService: AnimeService = ApiClient.animeApi.create(AnimeService::class.java)
}
