package com.example.progaiymhomeworks.extensions

import com.example.progaiymhomeworks.data.EpisodeDto
import com.example.progaiymhomeworks.data.models.EpisodeEntity

fun EpisodeDto.toEpisodeEntity(): EpisodeEntity {

    return EpisodeEntity(
        id = this.id,
        title = this.title,
        season = this.season,
        episodeN = this.episodeN,
        air_date = this.air_date,
        series = this.series
    )
}