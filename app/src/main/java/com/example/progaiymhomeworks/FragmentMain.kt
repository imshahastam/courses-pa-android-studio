package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

//экран, где данные должны отображаться
class FragmentMain : Fragment(R.layout.fragment_main) {

    private val dbInstance get() = Injector.database
    private lateinit var listener: OnButtonsClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataTxt = view.findViewById<AppCompatTextView>(R.id.dataTxt)

        val editBtn = view.findViewById<AppCompatButton>(R.id.editBtn)
        val deleteBtn = view.findViewById<AppCompatButton>(R.id.deleteBtn)

        val e = dbInstance.employeeDao().getById(1L)
        dataTxt.text = e.toString()

        editBtn.setOnClickListener {
            listener.openFragmentEdit()
        }

        //он в датабейзе удаляет данные, а на экране не отображает((
        deleteBtn.setOnClickListener {
            dbInstance.employeeDao().delete(e)
            dataTxt.text = e.toString()
        }
    }
}