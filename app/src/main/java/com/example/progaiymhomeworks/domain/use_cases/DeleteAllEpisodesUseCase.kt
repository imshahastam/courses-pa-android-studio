package com.example.progaiymhomeworks.domain.use_cases

import com.example.progaiymhomeworks.data.network.BreakingBadApi
import com.example.progaiymhomeworks.data.repo.BreakingBadRepo
import io.reactivex.Completable

class DeleteAllEpisodesUseCase(
    private val repo: BreakingBadRepo
) {
    operator fun invoke(): Completable {
        return repo.deleteAllEpisodes()
    }
}