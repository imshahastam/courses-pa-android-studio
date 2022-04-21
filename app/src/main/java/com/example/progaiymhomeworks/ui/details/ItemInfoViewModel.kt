package com.example.progaiymhomeworks.ui.details

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.progaiymhomeworks.App
import com.example.progaiymhomeworks.data.repo.BreakingBadRepo
import com.example.progaiymhomeworks.domain.use_cases.GetEpisodeByIdUseCase
import com.example.progaiymhomeworks.ui.main.Event
import io.reactivex.disposables.CompositeDisposable

class ItemInfoViewModel(application: Application) : AndroidViewModel(application)  {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var id: Long = -1
    fun setId(id: Long?) {
        this.id = id ?: -1
    }

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event

    private val breakingBadRepo = BreakingBadRepo(
        getApplication<App>().breakingBadApi,
        getApplication<App>().database.episodesDao()
    )

    private val getEpisodeByIdUseCase: GetEpisodeByIdUseCase =
        GetEpisodeByIdUseCase(breakingBadRepo)

    fun fetchEpisode() {
        compositeDisposable.add(
            getEpisodeByIdUseCase(id)
                .subscribe({
                    Log.e("SUBSCRIPTION_LEAK", "STILL_WORKING")
                    _event.value = Event.FetchedEpisode(it)
                }, {})
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}