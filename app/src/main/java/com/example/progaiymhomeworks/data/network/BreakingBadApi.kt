package com.example.progaiymhomeworks.data.network

import com.example.progaiymhomeworks.data.EpisodeDto
import com.example.progaiymhomeworks.data.ResponseDto
import com.example.progaiymhomeworks.database.Item
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BreakingBadApi {

    @GET("/api/episodes")
    fun getAllEpisodes(): Observable<List<EpisodeDto>>

    @GET("/api/episodes/{id}")
    fun getEpisode(@Path("id") id: Long? ): Single<List<Item>>

}