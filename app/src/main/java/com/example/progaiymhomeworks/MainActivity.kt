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
import com.example.progaiymhomeworks.R.color.red
import com.example.progaiymhomeworks.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

//Shahzada Stamova
class MainActivity : AppCompatActivity(), OnButtonsClick {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_container, Fragment1())
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_container2, Fragment2())
            .commit()
    }

    override fun setTextToFrg1(enteredText: String) {
        val fragment1 = supportFragmentManager.findFragmentById(R.id.frg_container) as? Fragment1
        fragment1?.getTextFromFrg2(enteredText)
    }

    override fun setTextToFrg2(enteredText: String) {
        val fragment2 = supportFragmentManager.findFragmentById(R.id.frg_container2) as? Fragment2
        fragment2?.getTextFromFrg1(enteredText)
    }

}