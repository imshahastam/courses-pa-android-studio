package com.example.progaiymhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txt = findViewById<AppCompatTextView>(R.id.txt)

        txt.text = intent.getStringExtra("itemText")
    }
}