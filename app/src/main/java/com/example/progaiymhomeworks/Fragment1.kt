package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment_1) {

    private lateinit var listener: OnButtonsClick
    private lateinit var textView: AppCompatTextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn1 = view.findViewById<AppCompatButton>(R.id.btn1)
        textView = view.findViewById(R.id.frg1Txt)
        val editText = view.findViewById<AppCompatEditText>(R.id.frg1EditText)

        btn1.setOnClickListener {
            listener.setTextToFrg2(editText.text.toString())
        }
    }

    fun getTextFromFrg2(value: String) {
        textView.text = value
    }
}