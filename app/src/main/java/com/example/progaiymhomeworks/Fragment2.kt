package com.example.progaiymhomeworks

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment_2) {

    private lateinit var image: AppCompatImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = view.findViewById(R.id.imageView)
    }

    fun getImage(img: Int){
        image.setImageResource(img)
    }
}