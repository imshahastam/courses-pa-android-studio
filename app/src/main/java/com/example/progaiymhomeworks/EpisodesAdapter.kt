package com.example.progaiymhomeworks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progaiymhomeworks.database.Episode

class EpisodesAdapter(private val click: (item: Long, pos: Boolean) -> Unit) : RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {

    private var list: List<Episode> = listOf()

    fun setData(list: List<Episode>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        itemView: View, private val click: (item: Long, pos: Boolean) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(episode: Episode) {

            val data = itemView.findViewById<AppCompatTextView>(R.id.itemData)

            data.text = episode.title

            itemView.setOnClickListener {
                click.invoke(episode.id!!, false)
            }
        }
    }
}