package com.example.progaiymhomeworks

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.progaiymhomeworks.database.Episode
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FragmentItemInfo : Fragment (R.layout.fragment_item_info) {

    private val dbInstance get() = Injector.database
    private val breakingBadApi get() = Injector.breakingBadApi
    private lateinit var listener: OnButtonsClick
    private lateinit var e: Episode

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = view.findViewById<AppCompatTextView>(R.id.titleTxt)
        val season = view.findViewById<AppCompatTextView>(R.id.seasonTxt)
        val episode = view.findViewById<AppCompatTextView>(R.id.episodeTxt)

        val id = arguments?.getLong("id")
        if (id != null) {
            breakingBadApi.getEpisode(id)
                .subscribeOn(Schedulers.io())
                .map {
                    it.first()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    title.text = it.title
                    season.text = it.season.toString()
                    episode.text = it.episode
                    Log.e(
                        "TAG",
                        "fragmentItemInfo doOnSuccess getById ${Thread.currentThread().name}"
                    )
                }
                .doOnError {
                    Log.e(
                        "TAG",
                        "fragmentItemInfo doOnError getById ${Thread.currentThread().name}"
                    )
                }
                .subscribe()
        }

    }

    private fun showToast(messageRes: String) {
        Toast.makeText(requireContext(), messageRes, Toast.LENGTH_SHORT).show()
    }

//    private fun showAlertDialog() {
//        val listener = DialogInterface.OnClickListener { _, which ->
//            when (which) {
//                DialogInterface.BUTTON_POSITIVE -> {
//                    dbInstance.employeeDao().delete(e)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .doOnComplete {
//                            Log.e("TAG", "fragmentItemInfo doOnComplete ${Thread.currentThread().name}")
//                        }
//                        .doOnError {
//                            Log.e("TAG", "fragmentItemInfo doOnError ${Thread.currentThread().name}")
//                        }
//                        .subscribe()
//                }
//                DialogInterface.BUTTON_NEGATIVE -> showToast("Don't delete")
//            }
//        }
//        val dialog = AlertDialog.Builder(requireContext())
//            .setCancelable(true)
//            .setTitle(R.string.alert_dialog_title)
//            .setPositiveButton("Yes", listener)
//            .setNegativeButton("No", listener)
//            .setOnCancelListener {
//                showToast("Cancel")
//            }
//            .create()
//
//        dialog.show()
//    }
}