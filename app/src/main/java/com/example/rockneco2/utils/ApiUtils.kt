package com.example.rockneco2.utils

import okhttp3.OkHttpClient
import okhttp3.Request

object ApiUtils {
    fun buildAuthHeader(token: String): Map<String, String> {
        return mapOf("Authorization" to "Bearer $token")
    }

    fun buildHeadersForRapidAPI(apiKey: String): Map<String, String> {
        return mapOf(
            "x-rapidapi-key" to apiKey,
            "x-rapidapi-host" to "anime-db.p.rapidapi.com"
        )
    }

    fun createRequestWithHeaders(url: String, headers: Map<String, String>): Request {
        val builder = Request.Builder().url(url)
        headers.forEach { (key, value) ->
            builder.addHeader(key, value)
        }
        return builder.build()
    }

    fun createHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
}
