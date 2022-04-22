package com.example.progaiymhomeworks.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.progaiymhomeworks.*
import com.example.progaiymhomeworks.databinding.ActivityMainBinding
import com.example.progaiymhomeworks.ui.OnButtonsClick
import com.example.progaiymhomeworks.ui.details.FragmentItemInfo

//Shahzada Stamova
class MainActivity : AppCompatActivity(), OnButtonsClick {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            openFragment(FragmentMain(), false)
        }

        /*supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container, FragmentMain())
            .commit()*/
    }

    override fun openFragment(frg: Fragment, addToBackStack: Boolean?) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frg_container, frg).apply {
                if(addToBackStack == true) {
                    addToBackStack("")
                }
            }
            .commit()
    }

}