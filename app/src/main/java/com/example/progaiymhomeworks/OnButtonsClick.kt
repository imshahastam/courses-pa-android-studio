package com.example.progaiymhomeworks

import android.graphics.drawable.Drawable
import android.view.View
import androidx.fragment.app.Fragment
import com.example.progaiymhomeworks.database.Employee

interface OnButtonsClick {

    fun openFragmentMain()
    fun openFragmentEdit(id: Long?)
    fun openFragmentEmployee()
    fun openItem(id: Long?)
}