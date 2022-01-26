package com.example.progaiymhomeworks

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.ContentProvider
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.progaiymhomeworks.R.color.red
import com.example.progaiymhomeworks.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

//Shahzada Stamova
class MainActivity : AppCompatActivity(), OnButtonsClick {

    private lateinit var binding: ActivityMainBinding
    private val dbInstance get() = Injector.database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container, FragmentMain())
            .commit()

    }

    override fun openFragmentMain() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container, FragmentMain())
            .commit()
    }

    override fun openFragmentEmployee() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container, FragmentEmployee())
            .commit()
    }

    override fun openFragmentEdit() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container, FragmentEdit())
            .commit()
    }

    override fun openItem(id: Long?) {

        val fragment = FragmentItemInfo()
        val bundle = Bundle()
        if (id != null) {
            bundle.putLong("id", id)
        }

        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container, fragment)
            .addToBackStack(null)
            .commit()
    }

}