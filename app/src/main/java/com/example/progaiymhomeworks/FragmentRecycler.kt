package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentRecycler : Fragment (R.layout.fragment_recycler) {

    private lateinit var listener: OnItemClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnItemClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.frg_recycler)
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = SimpleAdapter {
            Toast.makeText(requireContext(), "ITEM - $it", Toast.LENGTH_SHORT).show()
            listener.openItemInfo("ITEM  - $it")
        }

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM - $i")

        }
        adapter.setData(list)
    }
}