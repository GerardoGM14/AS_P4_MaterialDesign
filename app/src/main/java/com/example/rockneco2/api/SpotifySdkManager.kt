package com.example.rockneco2.api

import android.content.Context
import com.google.android.things.bluetooth.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote


object SpotifySdkManager {
    private const val CLIENT_ID = "03a8c5d22ef14ff9bde762e203258407"
    private const val REDIRECT_URI = "myapp://callback"
    private var spotifyAppRemote: SpotifyAppRemote? = null

    fun connect(context: Context, callback: (connected: Boolean) -> Unit) {
        val connectionParams = ConnectionParams.Builder(CLIENT_ID)
            .setRedirectUri(REDIRECT_URI)
            .showAuthView(true)
            .build()

        SpotifyAppRemote.connect(context, connectionParams, object : Connector.ConnectionListener {
            override fun onConnected(appRemote: SpotifyAppRemote) {
                spotifyAppRemote = appRemote
                callback(true)
            }

            override fun onFailure(throwable: Throwable) {
                throwable.printStackTrace()
                callback(false)
            }
        })
    }

    fun disconnect() {
        spotifyAppRemote?.let {
            SpotifyAppRemote.disconnect(it)
            spotifyAppRemote = null
        }
    }

    fun getSpotifyAppRemote(): SpotifyAppRemote? {
        return spotifyAppRemote
    }
}
