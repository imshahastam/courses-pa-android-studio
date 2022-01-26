package com.example.progaiymhomeworks

import android.graphics.drawable.Drawable
import android.view.View
import androidx.fragment.app.Fragment

interface OnButtonsClick {

    fun openFragmentMain()
    fun openFragmentEdit()
    fun openFragmentEmployee()
    fun openItem(id: Long?)
}