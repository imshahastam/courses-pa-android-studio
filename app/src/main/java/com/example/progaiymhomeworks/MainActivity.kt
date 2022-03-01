package com.example.progaiymhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.progaiymhomeworks.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//Shahzada Stamova
class MainActivity : AppCompatActivity(), OnButtonsClick {

    private lateinit var binding: ActivityMainBinding
    private val dbInstance get() = Injector.database
    private val breakingBadApi get() = Injector.breakingBadApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container, FragmentMain())
            .commit()
    }

    override fun openFragmentMain() {
        val fragment = FragmentMain()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container, fragment)
            .addToBackStack(null)
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