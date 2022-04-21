package com.example.progaiymhomeworks.domain.use_cases

import com.example.progaiymhomeworks.data.models.EpisodeEntity
import com.example.progaiymhomeworks.data.repo.BreakingBadRepo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetEpisodeByIdUseCase(
    private val repo: BreakingBadRepo
) {

    operator fun invoke(id: Long): Single<EpisodeEntity> {
        return repo.getEpisodeByIdInDB(id)
            .observeOn(AndroidSchedulers.mainThread())
    }
}