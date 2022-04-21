package com.example.progaiymhomeworks.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.progaiymhomeworks.ui.main.rv.EpisodesAdapter
import com.example.progaiymhomeworks.Injector
import com.example.progaiymhomeworks.R
import com.example.progaiymhomeworks.data.models.EpisodeEntity
import com.example.progaiymhomeworks.databinding.FragmentMainBinding
import com.example.progaiymhomeworks.extensions.showToast
import com.example.progaiymhomeworks.ui.OnButtonsClick
import com.example.progaiymhomeworks.ui.details.FragmentItemInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

//main экран, где данные должны отображаться
class FragmentMain : Fragment(), EpisodesAdapter.Listener {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    private lateinit var listener: OnButtonsClick

    private lateinit var vm: MainViewModel
    private val episodeAdapter: EpisodesAdapter = EpisodesAdapter(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as OnButtonsClick
        } catch (e: Exception) {
            print("Activity must implement OnButtonsClick")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        subcribeToLiveData()
        Log.e("VM", vm.hashCode().toString())
    }

    private fun setupViews() {
        with(binding) {
            val layoutManager = LinearLayoutManager(activity)
            recycler.layoutManager = layoutManager
            recycler.adapter = episodeAdapter
            recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))
            swipe.setOnRefreshListener {
                vm.loadEpisodes()
            }
        }
    }

    private fun subcribeToLiveData() {
        vm.episodesLiveData.observe(viewLifecycleOwner, {
            episodeAdapter.setData(it)
        })

        vm.event.observe(viewLifecycleOwner, {
            when(it) {
                is Event.ShowToast -> showToast(getString(it.resId))
                is Event.ShowLoading -> binding.swipe.isRefreshing = true
                is Event.StopLoading -> binding.swipe.isRefreshing = false
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vm.clearEvents()
        _binding = null
    }

    override fun onClick(index: Int) {
        vm.getEpisodeByIndex(index)?.let {
            listener.openFragment(FragmentItemInfo.newInstance(it.id))
        }
    }
}