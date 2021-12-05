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
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //numbers
        binding.apply {
            zeroBtn.setOnClickListener { inputView("0") }
            oneBtn.setOnClickListener { inputView("1") }
            twoBtn.setOnClickListener { inputView("2") }
            threeBtn.setOnClickListener { inputView("3") }
            fourBtn.setOnClickListener { inputView("4") }
            fiveBtn.setOnClickListener { inputView("5") }
            sixBtn.setOnClickListener { inputView("6") }
            sevenBtn.setOnClickListener { inputView("7") }
            eightBtn.setOnClickListener { inputView("8") }
            nineBtn.setOnClickListener { inputView("9") }
        }

        //operations
        binding.apply {
            plus.setOnClickListener { inputView("+") }
            minus.setOnClickListener { inputView("-") }
            divide.setOnClickListener { inputView("/") }
            multiply.setOnClickListener { inputView("*") }
        }

        //other
        binding.apply {
            cleanAllBtn.setOnClickListener {
                inputTxt.text = ""
                answerTxt.text = ""
            }
            bracketOpenBtn.setOnClickListener { inputView("(") }
            bracketCloseBtn.setOnClickListener { inputView(")") }
            dotBtn.setOnClickListener { inputView(".") }

            backBtn.setOnClickListener {
                val inptTxt = inputTxt.text.toString()
                inputTxt.text = inptTxt.substring(0, inptTxt.length - 1)
            }
        }

        binding.apply {
            equalBtn.setOnClickListener{
                try {
                    val expression = ExpressionBuilder(inputTxt.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()

                    if (result == longResult.toDouble()) {
                        answerTxt.text = longResult.toString()
                    } else {
                        answerTxt.text = result.toString()
                    }
                }catch (e: ArithmeticException) {
                    answerTxt.text = "На 0 делить нельзя!"
                } catch (e: Exception) {
                    answerTxt.text = "Ошибка!"
            }
        }


    }
}
    private fun inputView(text: String) {
        binding.inputTxt.append(text)
    }
}