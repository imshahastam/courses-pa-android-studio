package com.example.progaiymhomeworks.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.progaiymhomeworks.App
import com.example.progaiymhomeworks.R
import com.example.progaiymhomeworks.data.models.EpisodeEntity
import com.example.progaiymhomeworks.data.repo.BreakingBadRepo
import com.example.progaiymhomeworks.domain.use_cases.GetEpisodesAsLiveDataUseCase
import com.example.progaiymhomeworks.domain.use_cases.GetEpisodesUseCase
import io.reactivex.disposables.CompositeDisposable
import java.net.UnknownHostException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val breakingBadRepo = BreakingBadRepo (
        getApplication<App>().breakingBadApi,
        getApplication<App>().database.episodesDao()
    )

    private val getEpisodesUseCase = GetEpisodesUseCase(breakingBadRepo)

    private val getEpisodesAsLiveUseCase = GetEpisodesAsLiveDataUseCase(breakingBadRepo)

    val episodesLiveData: LiveData<List<EpisodeEntity>> = getEpisodesAsLiveUseCase()

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event

    init {
        loadEpisodes()
    }

    fun loadEpisodes() {
        _event.value = Event.ShowLoading
        compositeDisposable.add(
            getEpisodesUseCase()
                .doOnTerminate { _event.value = Event.StopLoading }
                .subscribe({
                    Log.e("TAG", "loadEp sub")
                }, {
                    handleError(it)
                })
        )
    }

    private fun handleError(it: Throwable) {
        _event.value = when (it) {
            is UnknownHostException -> Event.ShowToast(R.string.no_internet)
            else -> Event.ShowToast(R.string.error_unknown)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun clearEvents() {
        _event.value = null
    }

    fun getEpisodeByIndex(index: Int): EpisodeEntity? {
        return episodesLiveData.value?.get(index)
    }
}