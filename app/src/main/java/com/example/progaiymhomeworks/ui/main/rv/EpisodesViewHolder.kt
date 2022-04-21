package com.example.progaiymhomeworks.ui.main.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.progaiymhomeworks.data.models.EpisodeEntity
import com.example.progaiymhomeworks.databinding.ItemRecyclerBinding

class EpisodesViewHolder(
    private val binding: ItemRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: EpisodeEntity) {
        with(binding) {
            itemData.text = item.title
        }
    }

    companion object {
        fun create(parent: ViewGroup, listener: EpisodesAdapter.Listener): EpisodesViewHolder {

            val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context))

            return EpisodesViewHolder(binding).apply {
                itemView.setOnClickListener {
                    listener.onClick(adapterPosition)
                }
            }
        }
    }
}