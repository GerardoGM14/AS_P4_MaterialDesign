package com.example.rockneco2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rockneco2.databinding.ItemAnimeBinding
import com.example.rockneco2.model.Anime
import com.example.rockneco2.R



class AnimeAdapter(private var animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    inner class AnimeViewHolder(val binding: ItemAnimeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animeList[position]

        holder.binding.animeTitle.text = anime.title
        holder.binding.animeDescription.text = anime.synopsis

        // Glide para cargar la imagen
        Glide.with(holder.itemView.context)
            .load(anime.image) // URL de la imagen
            .placeholder(R.drawable.ic_placeholder) // Imagen predeterminada
            .into(holder.binding.animeImage)
    }

    override fun getItemCount(): Int = animeList.size

    // Método para actualizar los datos dinámicamente
    fun updateAnimes(newAnimeList: List<Anime>) {
        animeList = newAnimeList
        notifyDataSetChanged()
    }
}

