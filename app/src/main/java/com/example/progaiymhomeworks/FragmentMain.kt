package com.example.progaiymhomeworks

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

//экран, где данные должны отображаться
class FragmentMain : Fragment(R.layout.fragment_main) {

    private val dbInstance get() = Injector.database

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataTxt = view.findViewById<AppCompatTextView>(R.id.dataTxt)

        val e = dbInstance.employeeDao().getById(1L)
        dataTxt.text = e.toString()
    }
}