package com.example.progaiymhomeworks.ui.main

import androidx.annotation.StringRes
import com.example.progaiymhomeworks.data.models.EpisodeEntity

sealed class Event(){
    class ShowToast(@StringRes val resId: Int): Event()
    object ShowLoading: Event()
    object StopLoading: Event()
    class FetchedEpisode(val episode: EpisodeEntity): Event()
}