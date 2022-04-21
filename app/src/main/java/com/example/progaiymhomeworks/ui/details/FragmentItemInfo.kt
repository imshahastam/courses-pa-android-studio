package com.example.progaiymhomeworks.ui.details

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.progaiymhomeworks.Injector
import com.example.progaiymhomeworks.R
import com.example.progaiymhomeworks.data.models.EpisodeEntity
import com.example.progaiymhomeworks.databinding.FragmentItemInfoBinding
import com.example.progaiymhomeworks.ui.OnButtonsClick
import com.example.progaiymhomeworks.ui.main.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FragmentItemInfo : Fragment (R.layout.fragment_item_info) {

    private var _binding: FragmentItemInfoBinding? = null
    private val binding: FragmentItemInfoBinding
        get() = _binding!!

    private lateinit var viewModel: ItemInfoViewModel

    private lateinit var listener: OnButtonsClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ItemInfoViewModel::class.java]
        Log.e("DETAIL_VM", viewModel.toString())
        viewModel.setId(arguments?.getLong(Long::class.java.canonicalName))

        viewModel.fetchEpisode()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemInfoBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.event.observe(viewLifecycleOwner, {
            when (it) {
                is Event.FetchedEpisode -> binding.apply {
                    titleTxt.text = it.episode.title
                    episodeTxt.text = it.episode.series
                    seasonTxt.text = it.episode.season.toString()
                }
            }
        })
    }

    companion object {
        fun newInstance(id: Long): FragmentItemInfo {
            val args = Bundle().apply { putLong(Long::class.java.canonicalName, id) }
            return FragmentItemInfo().apply { arguments = args }
        }
    }
}