package com.example.progaiymhomeworks.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.progaiymhomeworks.data.models.EpisodeEntity

@Database(entities = [EpisodeEntity::class], version = 4)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodesDao(): EpisodesDao

}