package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class FragmentEdit : Fragment(R.layout.fragment_edit) {

    private val dbInstance get() = Injector.database
    private lateinit var listener: OnButtonsClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editName = view.findViewById<AppCompatEditText>(R.id.nameEdit)
        val editCompany = view.findViewById<AppCompatEditText>(R.id.companyEdit)
        val editSalary = view.findViewById<AppCompatEditText>(R.id.salaryEdit)

        val btnSaveEdit = view.findViewById<AppCompatButton>(R.id.saveBtnEdit)

        val id = arguments?.getLong("id")
        val e = dbInstance.employeeDao().getById(id)

        Log.e("TAG", "Edit id = $id, e.name = ${e.name}")

        btnSaveEdit.setOnClickListener {

            e.name = editName.text.toString()
            e.company = editCompany.text.toString()
            e.salary = editSalary.text.toString().toInt()
            dbInstance.employeeDao().update(e)

            listener.openFragmentMain()
            Log.e("TAG", "Edit id 1 = $id, e.name = ${e.name}")
        }

    }

}