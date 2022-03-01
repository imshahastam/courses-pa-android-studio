package com.example.progaiymhomeworks

import android.content.ClipData
import com.example.progaiymhomeworks.database.Episode
import com.example.progaiymhomeworks.database.EpisodesResult
import com.example.progaiymhomeworks.database.Item
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface BreakingBadApi {

    @GET("/api/episodes")
    fun getAllEpisodes(): Observable<List<Item>>

    @GET("/api/episodes/{id}")
    fun getEpisode(@Path("id") id: Long? ): Single<List<Item>>

}