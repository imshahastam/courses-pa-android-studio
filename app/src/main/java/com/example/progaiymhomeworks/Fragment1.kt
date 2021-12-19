package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment_1) {

    private lateinit var listener: OnButtonsClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn1 = view.findViewById<AppCompatButton>(R.id.btn1)
        val btn2 = view.findViewById<AppCompatButton>(R.id.btn2)
        val btn3 = view.findViewById<AppCompatButton>(R.id.btn3)

        btn1.setOnClickListener {
            listener.setImageClick(R.drawable.image1)
        }
        btn2.setOnClickListener {
            listener.setImageClick(R.drawable.image2)
        }
        btn3.setOnClickListener {
            listener.setImageClick(R.drawable.image3)
        }
    }
}