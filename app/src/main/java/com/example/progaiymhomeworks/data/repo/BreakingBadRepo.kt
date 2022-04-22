package com.example.progaiymhomeworks.data.repo

import com.example.progaiymhomeworks.data.EpisodeDto
import com.example.progaiymhomeworks.data.ResponseDto
import com.example.progaiymhomeworks.data.models.EpisodeEntity
import com.example.progaiymhomeworks.data.network.BreakingBadApi
import com.example.progaiymhomeworks.data.storage.EpisodesDao
import com.example.progaiymhomeworks.database.Item
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BreakingBadRepo (
    private val breakingBadApi: BreakingBadApi,
    private val episodesDao: EpisodesDao
    ) {

    fun getAllEpisodes(): Observable<List<EpisodeDto>> {
        return breakingBadApi.getAllEpisodes()
            .subscribeOn(Schedulers.io())
    }

    fun insertList(episodesList: List<EpisodeEntity>) {
        episodesDao.insertList(episodesList)
    }

    fun deleteAllEpisodes(): Completable {
        return episodesDao.deleteAll()
            .subscribeOn(Schedulers.io())
    }

    fun getEpisodeByIdInDB(id: Long?): Single<EpisodeEntity> {
        return episodesDao.getById(id)
            .subscribeOn(Schedulers.io())
    }

    fun getEpisodesAsLiveD() = episodesDao.getAll()
}