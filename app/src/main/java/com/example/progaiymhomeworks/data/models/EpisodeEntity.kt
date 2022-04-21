package com.example.progaiymhomeworks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EpisodeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var title: String,
    val season: Int,
    val episodeN: Int,
    val air_date: String?,
    val series: String?
)