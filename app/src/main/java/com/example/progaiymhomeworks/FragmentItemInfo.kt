package com.example.progaiymhomeworks

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.progaiymhomeworks.database.Employee

class FragmentItemInfo : Fragment (R.layout.fragment_item_info) {

    private val dbInstance get() = Injector.database
    private lateinit var listener: OnButtonsClick
    private lateinit var e: Employee

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
        e = dbInstance.employeeDao().getById(id)

        nameInfo.text = e.name
        salaryInfo.text = e.salary.toString()
        companyInfo.text = e.company

        val editBtn = view.findViewById<AppCompatButton>(R.id.editBtn)
        editBtn.setOnClickListener {
            listener.openFragmentEdit(id)
        }

        val deleteBtn = view.findViewById<AppCompatButton>(R.id.deleteBtn)
        deleteBtn.setOnClickListener {
            //dbInstance.employeeDao().delete(e)
            showAlertDialog()
        }

    }

    private fun showToast(messageRes: String) {
        Toast.makeText(requireContext(), messageRes, Toast.LENGTH_SHORT).show()
    }

    private fun showAlertDialog() {
        val listener = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    dbInstance.employeeDao().delete(e)
                }
                DialogInterface.BUTTON_NEGATIVE -> showToast("Don't delete")
            }
        }
        val dialog = AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setTitle(R.string.alert_dialog_title)
            .setPositiveButton("Yes", listener)
            .setNegativeButton("No", listener)
            .setOnCancelListener {
                showToast("Cancel")
            }
            .create()

        dialog.show()
    }
}