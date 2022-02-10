package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.example.progaiymhomeworks.database.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

        btnSaveEdit.setOnClickListener {
            val e = dbInstance.employeeDao().getById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    it.name = editName.text.toString()
                    it.company = editCompany.text.toString()
                    it.salary = editSalary.text.toString().toInt()
                    it
                }
                .observeOn(Schedulers.io())
                .flatMapCompletable {
                    dbInstance.employeeDao().update(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete {
                    Log.e("TAG", "fragmentEdit doOnSuccess ${Thread.currentThread().name}")
                    requireActivity().onBackPressed()
                }
                .doOnError {
                    Log.e("TAG", "fragmentEdit doOnError ${Thread.currentThread().name}")
                }
                .subscribe()
        }

    }

}