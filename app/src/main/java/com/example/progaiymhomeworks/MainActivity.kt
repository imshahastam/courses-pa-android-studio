package com.example.progaiymhomeworks

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.progaiymhomeworks.R.color.red

class MainActivity : AppCompatActivity() {

    private var count = 0
    lateinit var textView: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<AppCompatTextView>(R.id.textView)

        if (savedInstanceState != null) {
            val score = savedInstanceState.getInt("score")
            count = score
            textView.text = count.toString()
        }

        val countButton = findViewById<AppCompatButton>(R.id.countButton)
        val resetButton = findViewById<AppCompatButton>(R.id.resetButton)

        countButton.setOnClickListener{
            ++count
            textView.text = count.toString()
        }

        resetButton.setOnClickListener{
            count = 0
            textView.text = count.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("score", count)
    }
}