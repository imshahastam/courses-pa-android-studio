package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
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
        txt.text = arguments?.getString("item")
    }
}