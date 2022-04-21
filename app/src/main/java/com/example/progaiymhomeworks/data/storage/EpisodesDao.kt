package com.example.progaiymhomeworks.data.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.progaiymhomeworks.data.models.EpisodeEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface EpisodesDao {

    @Query("SELECT * FROM EpisodeEntity")
    fun getAll(): LiveData<List<EpisodeEntity>>

    @Query("SELECT * FROM EpisodeEntity WHERE id = :id")
    fun getById(id: Long?): Single<EpisodeEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(episodesList: List<EpisodeEntity>)

    @Insert
    fun insert(episode: EpisodeEntity) : Long

    @Update
    fun update(episode: EpisodeEntity)

    @Delete
    fun delete(episode: EpisodeEntity)

    @Query("DELETE from EpisodeEntity")
    fun deleteAll(): Completable
}