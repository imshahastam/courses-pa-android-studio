package com.example.progaiymhomeworks.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Episode(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    var title: String,
    val season: Int,
    val episodeN: Int,
    val air_date: String?,
    val series: String?
)