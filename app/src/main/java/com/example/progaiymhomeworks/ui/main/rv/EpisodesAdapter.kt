package com.example.progaiymhomeworks.ui.main.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progaiymhomeworks.R
import com.example.progaiymhomeworks.data.models.EpisodeEntity

class EpisodesAdapter(private val listener: Listener) : RecyclerView.Adapter<EpisodesViewHolder>() {

    private val items = arrayListOf<EpisodeEntity>()

    fun setData(list: List<EpisodeEntity>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        return EpisodesViewHolder.create(parent, listener)
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    interface Listener {
        fun onClick(index: Int)
    }
}