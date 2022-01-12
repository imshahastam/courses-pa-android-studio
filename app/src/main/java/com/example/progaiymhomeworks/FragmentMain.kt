package com.example.progaiymhomeworks

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class FragmentMain : Fragment(R.layout.fragment_main) {

    private val pref get() = Injector.pref

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txt = view.findViewById<AppCompatTextView>(R.id.txt)
    }
}