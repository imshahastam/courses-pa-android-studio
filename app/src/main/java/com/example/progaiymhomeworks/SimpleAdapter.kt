package com.example.progaiymhomeworks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SimpleAdapter (
    private val click: (pos: Int) -> Unit) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = listOf<String>()

    fun setData(list: List<String>) {
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
        itemView: View,
        private val click: (pos: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) {
            val img = itemView.findViewById<AppCompatImageView>(R.id.itemImg)
            val txt = itemView.findViewById<AppCompatTextView>(R.id.itemTxt)

            if (adapterPosition % 2 == 0) {
                Glide.with(itemView.context)
                    .load("https://cdn0.iconfinder.com/data/icons/seo-web-4-1/128/Vigor_User-Avatar-Profile-Photo-02-512.png")
                    .into(img)
            } else {
                Glide.with(itemView.context)
                    .load("https://cdn0.iconfinder.com/data/icons/seo-web-4-1/128/Vigor_User-Avatar-Profile-Photo-01-512.png")
                    .into(img)
            }

            txt.text = item
            itemView.setOnClickListener {
                click.invoke(adapterPosition)
            }
        }
    }
}