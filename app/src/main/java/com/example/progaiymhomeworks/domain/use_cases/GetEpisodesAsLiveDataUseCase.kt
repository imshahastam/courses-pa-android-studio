package com.example.progaiymhomeworks.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.progaiymhomeworks.data.models.EpisodeEntity
import com.example.progaiymhomeworks.data.repo.BreakingBadRepo

class GetEpisodesAsLiveDataUseCase(
    private val repo: BreakingBadRepo
) {

    operator fun invoke(): LiveData<List<EpisodeEntity>> {
        return repo.getEpisodesAsLiveD()
    }
}