package com.platzi.android.rickandmorty.usecases.repositories

import com.platzi.android.rickandmorty.domain.Episode
import io.reactivex.Single

interface EpisodeRepository {
    fun getEpisodeFromCharacter(episodeUrlList: List<String>): Single<List<Episode>>
}
