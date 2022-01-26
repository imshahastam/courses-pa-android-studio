package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class FragmentItemInfo : Fragment (R.layout.fragment_item_info) {

    private val dbInstance get() = Injector.database
    private lateinit var listener: OnButtonsClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameInfo = view.findViewById<AppCompatTextView>(R.id.nameInfo)
        val companyInfo = view.findViewById<AppCompatTextView>(R.id.companyInfo)
        val salaryInfo = view.findViewById<AppCompatTextView>(R.id.salaryInfo)

        val id = arguments?.getLong("id")
        val e = dbInstance.employeeDao().getById(id)

        nameInfo.text = e.name
        salaryInfo.text = e.salary.toString()
        companyInfo.text = e.company

    }
}