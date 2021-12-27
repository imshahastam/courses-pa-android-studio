package com.example.progaiymhomeworks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class FragmentItemInfo : Fragment(R.layout.fragment_item_info) {

    private lateinit var txt: AppCompatTextView
    private lateinit var listener: OnItemClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnItemClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.frgInfoTxt)

        val itemText = arguments?.getString("item")
        txt.text = itemText

        val btn = view.findViewById<AppCompatButton>(R.id.frgInfoBtn)

        btn.setOnClickListener {
            val intent = Intent("openActivity2")
            intent.putExtra("itemText", itemText)
            startActivity(intent)
        }
    }
}