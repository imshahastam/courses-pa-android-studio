package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.example.progaiymhomeworks.database.Employee

//экран, где вводим данные через эдиты
class FragmentEmployee : Fragment (R.layout.fragment_employee) {

    private val dbInstance get() = Injector.database
    private lateinit var listener: OnButtonsClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<AppCompatEditText>(R.id.nameEditText)
        val company = view.findViewById<AppCompatEditText>(R.id.companyEditText)
        val salary = view.findViewById<AppCompatEditText>(R.id.salaryEditText)

        val btnSave = view.findViewById<AppCompatButton>(R.id.saveBtn)

        btnSave.setOnClickListener {
            val e = Employee (
                id = 1L,
                name = name.text.toString(),
                company = company.text.toString(),
                salary = salary.text.toString().toInt()
            )
            dbInstance.employeeDao().insert(e)

            listener.openFragment()
        }
    }
}