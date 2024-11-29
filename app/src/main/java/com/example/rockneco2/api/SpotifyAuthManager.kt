package com.example.rockneco2.api

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

object SpotifyAuthManager {

    private const val CLIENT_ID = "03a8c5d22ef14ff9bde762e203258407"
    private const val CLIENT_SECRET = "c6b69f2647fa498da4b977d9d3d8f0c0"
    private const val REDIRECT_URI = "myapp://callback"
    private const val AUTH_URL = "https://accounts.spotify.com/authorize"
    private const val TOKEN_URL = "https://accounts.spotify.com/api/token"
    private const val SCOPES = "user-read-private user-read-email streaming"

    var accessToken: String? = null
        private set

    fun getAuthUrl(): String {
        return "$AUTH_URL?client_id=$CLIENT_ID&response_type=code&redirect_uri=$REDIRECT_URI&scope=$SCOPES"
    }

    fun handleRedirectUri(context: Context, uri: Uri, onSuccess: () -> Unit, onError: (String) -> Unit) {
        val code = uri.getQueryParameter("code")
        if (code != null) {
            fetchAccessToken(code, onSuccess, onError)
        } else {
            onError("Authorization code not found")
        }
    }

    private fun fetchAccessToken(code: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        val client = OkHttpClient()

        val formBody = FormBody.Builder()
            .add("grant_type", "authorization_code")
            .add("code", code)
            .add("redirect_uri", REDIRECT_URI)
            .add("client_id", CLIENT_ID)
            .add("client_secret", CLIENT_SECRET)
            .build()

        val request = Request.Builder()
            .url(TOKEN_URL)
            .post(formBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("SpotifyAuth", "Failed to fetch access token", e)
                onError("Failed to fetch access token: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    response.body?.let {
                        val json = JSONObject(it.string())
                        accessToken = json.getString("access_token")
                        Log.d("SpotifyAuth", "Access token received: $accessToken")
                        onSuccess()
                    } ?: onError("Empty response body")
                } else {
                    onError("Failed to fetch access token: ${response.message}")
                }
            }
        })
    }
}

