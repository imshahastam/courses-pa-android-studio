package com.example.progaiymhomeworks

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class FragmentAbout : Fragment(R.layout.fragment_about){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbarAbout)
        toolbar.inflateMenu(R.menu.menu)

        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.back -> {
                    requireActivity().onBackPressed()
                }
            }
            true
        }
    }
}