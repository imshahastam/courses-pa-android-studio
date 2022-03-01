package com.example.progaiymhomeworks.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Episode::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodesDao(): EpisodesDao

}