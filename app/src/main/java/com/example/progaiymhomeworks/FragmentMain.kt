package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progaiymhomeworks.database.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//main экран, где данные должны отображаться
class FragmentMain : Fragment(R.layout.fragment_main) {

    private val dbInstance get() = Injector.database
    private lateinit var listener: OnButtonsClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addBtn = view.findViewById<AppCompatButton>(R.id.addBtn)

        val adapter = ContactsAdapter {item: Long, pos: Boolean ->
                listener.openItem(item)
        }

        val eList = dbInstance.employeeDao().getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                adapter.setData(it)
            }
            .doOnNext {
                Log.e("TAG", "fragmentMain doOnNext ${Thread.currentThread().name}")
            }
            .subscribe()


        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = adapter

        recycler.layoutManager = LinearLayoutManager(requireContext())

        addBtn.setOnClickListener {
            listener.openFragmentEmployee()
        }
    }
}