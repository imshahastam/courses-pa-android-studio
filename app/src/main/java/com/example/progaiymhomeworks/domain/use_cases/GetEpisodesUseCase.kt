package com.example.progaiymhomeworks.domain.use_cases

import com.example.progaiymhomeworks.data.models.EpisodeEntity
import com.example.progaiymhomeworks.data.repo.BreakingBadRepo
import com.example.progaiymhomeworks.extensions.toEpisodeEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetEpisodesUseCase(
    private val repo: BreakingBadRepo
) {

    operator fun invoke(): Observable<Unit> {
        return repo.getAllEpisodes()
            .map {
                val listEp = mutableListOf<EpisodeEntity>()
                it.forEach {
                    listEp.add(it.toEpisodeEntity())
                }
                listEp.toList()
            }
            .map {
                repo.insertList(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}