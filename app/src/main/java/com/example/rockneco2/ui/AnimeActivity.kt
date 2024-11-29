package com.example.rockneco2.ui
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rockneco2.adapter.AnimeAdapter
import com.example.rockneco2.api.ApiServiceProvider
import com.example.rockneco2.databinding.ActivityAnimeBinding
import com.example.rockneco2.model.Anime
import retrofit2.Call
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class AnimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimeBinding
    private lateinit var adapter: AnimeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AnimeAdapter(listOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        fetchAnimeData()
    }

    private fun fetchAnimeData() {
        // Usar corrutinas para realizar la llamada de red
        lifecycleScope.launch {
            try {
                val animes = ApiServiceProvider.animeService.fetchAnimes()
                if (animes != null) {
                    adapter.updateAnimes(animes) // Pasar los datos al adaptador
                } else {
                    Toast.makeText(
                        this@AnimeActivity,
                        "Error al cargar animes",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(
                    this@AnimeActivity,
                    "Error al cargar animes: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

