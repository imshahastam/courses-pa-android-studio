package com.example.progaiymhomeworks.ui

import androidx.fragment.app.Fragment

interface OnButtonsClick {

    fun openFragment(frg: Fragment, addToBackStack: Boolean? = true) {}
}