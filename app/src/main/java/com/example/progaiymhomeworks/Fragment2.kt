package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment_2) {

    private lateinit var listener: OnButtonsClick
    private lateinit var textView: AppCompatTextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn2 = view.findViewById<AppCompatButton>(R.id.btn2)
        textView = view.findViewById<AppCompatTextView>(R.id.frg2Txt)
        val editText = view.findViewById<AppCompatEditText>(R.id.frg2EditText)

        btn2.setOnClickListener {
            listener.setTextToFrg1(editText.text.toString())
        }
    }

    fun getTextFromFrg1(value: String) {
        textView.text = value
    }
}