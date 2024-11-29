package com.example.rockneco2.api
import com.example.rockneco2.model.Anime
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("/anime")
    suspend fun getAllAnimes(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10,
        @Query("search") search: String? = null,
        @Query("sortBy") sortBy: String? = null,
        @Query("sortOrder") sortOrder: String? = null,
        @Query("genres") genres: String? = null
    ): Response<List<Anime>> // Cambiado a Response para corrutinas
}


