package com.example.rockneco2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rockneco2.databinding.ItemMusicBinding
import com.example.rockneco2.model.Song
import com.bumptech.glide.Glide

class MusicAdapter(private var musicList: List<Song>) :
    RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    inner class MusicViewHolder(private val binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(song: Song) {
            binding.musicTitle.text = song.title
            binding.musicArtist.text = song.artist

            // Cargar la imagen del álbum o canción usando Glide
            Glide.with(binding.root.context)
                .load(song.imageUrl) // URL de la imagen
                .placeholder(R.drawable.ic_placeholder) // Placeholder por defecto
                .into(binding.albumImage) // ImageView de tu diseño
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding =
            ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musicList[position])
    }

    override fun getItemCount(): Int = musicList.size

    fun updateMusicList(newMusicList: List<Song>) {
        musicList = newMusicList
        notifyDataSetChanged()
    }
}
