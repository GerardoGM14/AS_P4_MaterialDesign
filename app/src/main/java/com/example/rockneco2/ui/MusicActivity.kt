package com.example.rockneco2.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rockneco2.adapter.MusicAdapter
import com.example.rockneco2.api.ApiServiceProvider
import com.example.rockneco2.databinding.ActivityMusicBinding
import com.example.rockneco2.model.Song
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MusicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicBinding
    private lateinit var adapter: MusicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar RecyclerView y Adaptador
        adapter = MusicAdapter(listOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Configurar el botón de búsqueda
        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            if (query.isNotEmpty()) {
                searchMusic(query)
            } else {
                Toast.makeText(this, "Por favor, ingresa un término de búsqueda", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun searchMusic(query: String) {
        lifecycleScope.launch {
            try {
                // Llamada a la API
                val songs = ApiServiceProvider.spotifyService.searchSongs(query)
                if (songs.isNotEmpty()) {
                    adapter.updateMusicList(songs)
                } else {
                    Toast.makeText(this@MusicActivity, "No se encontraron resultados", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@MusicActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
