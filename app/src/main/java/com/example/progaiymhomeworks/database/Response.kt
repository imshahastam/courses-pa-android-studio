package com.example.progaiymhomeworks.database

data class EpisodesResult(
    val items: List<Item>
)

data class Item(
    val episode_id: Long?,
    val title: String?,
    val season: Int,
    val air_date: String?,
    val characters: List<String>,
    val episode: String,
    val series: String?
)
