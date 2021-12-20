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
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progaiymhomeworks.R.color.red
import com.example.progaiymhomeworks.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

//Shahzada Stamova
class MainActivity : AppCompatActivity(), OnItemClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_container, FragmentRecycler())
            .commit()

    }

    override fun openItemInfo(text: String) {
        val fragmentInfo = FragmentItemInfo()
        val bundle = Bundle()
        bundle.putString("item", text)
        fragmentInfo.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container, fragmentInfo)
            .addToBackStack(null)
            .commit()
    }
}