package com.example.progaiymhomeworks

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.View.inflate
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.fragment.app.Fragment
import com.example.progaiymhomeworks.databinding.ActivityMainBinding.inflate
import com.example.progaiymhomeworks.databinding.FragmentMainBinding.inflate
import com.example.progaiymhomeworks.databinding.FragmentRegisterBinding.inflate

class FragmentMain : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu)

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.frg_container, FragmentAbout())
                        .addToBackStack(null)
                        .commit()
                }
            }
            true
        }
    }
}