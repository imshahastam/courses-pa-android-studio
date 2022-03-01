package com.example.progaiymhomeworks

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.progaiymhomeworks.database.Episode
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//main экран, где данные должны отображаться
class FragmentMain : Fragment(R.layout.fragment_main) {

    private val dbInstance get() = Injector.database
    private val breakingBadApi get() = Injector.breakingBadApi
    private lateinit var listener: OnButtonsClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.swipe)

        val adapter = EpisodesAdapter { item: Long, pos: Boolean ->
                listener.openItem(item)
        }

            breakingBadApi.getAllEpisodes()
                .subscribeOn(Schedulers.io())
                .map {
                    val listEp = mutableListOf<Episode>()
                    it.forEach {
                        val episode = Episode(
                            id = it.episode_id,
                            title = it.title.toString(),
                            season = it.season,
                            air_date = it.air_date,
                            episodeN = it.episode.toInt(),
                            series = it.series
                        )
                        listEp.add(episode)
                    }
                    listEp.toList()
                }
                .map {
                    dbInstance.episodesDao().insertList(it)
                    it
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    adapter.setData(it)
                    Log.e("TAG", "fragmentMain doOnNext ${Thread.currentThread().name}")
                    Log.e("TAG", "fragmentMain ${it}")
                }
                .subscribe()

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        swipe.setOnRefreshListener {
            breakingBadApi.getAllEpisodes()
            adapter.notifyDataSetChanged()
        }

    }
}