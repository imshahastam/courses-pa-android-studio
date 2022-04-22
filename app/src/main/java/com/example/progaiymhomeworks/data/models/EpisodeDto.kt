package com.example.progaiymhomeworks.data

data class EpisodeDto(
    val id: Long,
    val title: String,
    val season: Int,
    val episodeN: Int,
    val air_date: String?,
    val series: String?
)