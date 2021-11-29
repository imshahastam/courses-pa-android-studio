package com.example.progaiymhomeworks

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private lateinit var textView: AppCompatTextView
    private lateinit var layout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.layout)
        textView = findViewById(R.id.textView)

        val redButton = findViewById<AppCompatButton>(R.id.redButton)
        val yellowButton = findViewById<AppCompatButton>(R.id.yellowButton)
        val greenButton = findViewById<AppCompatButton>(R.id.greenButton)

        redButton.setOnClickListener(::OnClick)
        yellowButton.setOnClickListener(::OnClick)
        greenButton.setOnClickListener(::OnClick)
    }
    private fun OnClick (view: View){
        when (view.id) {
            R.id.redButton -> {
                textView.text = "RED"
                layout.setBackgroundColor(Color.RED)
            }

            R.id.yellowButton -> {
                textView.text = "YELLOW"
                layout.setBackgroundColor(Color.YELLOW)
            }

            R.id.greenButton -> {
                textView.text = "GREEN"
                layout.setBackgroundColor(Color.GREEN)
            }
            else -> textView.text = "Unknown"
        }

    }
}