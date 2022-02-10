package com.example.progaiymhomeworks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progaiymhomeworks.database.Employee
import io.reactivex.Observable

class ContactsAdapter(private val click: (item: Long, pos: Boolean) -> Unit) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    private var list: List<Employee> = listOf()

    fun setData(list: List<Employee>) {
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

        fun bind(employee: Employee) {

            val data = itemView.findViewById<AppCompatTextView>(R.id.itemData)

            data.text = employee.name

            itemView.setOnClickListener {
                click.invoke(employee.id!!, false)
            }
        }
    }
}

