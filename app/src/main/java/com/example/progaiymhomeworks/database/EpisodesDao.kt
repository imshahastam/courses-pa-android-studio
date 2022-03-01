package com.example.progaiymhomeworks.database

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface EpisodesDao {

    @Query("SELECT * FROM episode")
    fun getAll(): Observable<List<Episode>>

    @Query("SELECT * FROM episode WHERE id = :id")
    fun getById(id: Long?): Single<Episode>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(episodesList: List<Episode>)

    @Insert
    fun insert(episode: Episode) : Completable

    @Update
    fun update(episode: Episode) : Completable

    @Delete
    fun delete(episode: Episode) : Completable
}