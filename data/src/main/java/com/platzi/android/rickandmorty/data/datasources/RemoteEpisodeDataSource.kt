package com.platzi.android.rickandmorty.data.datasources

import com.platzi.android.rickandmorty.domain.Episode
import io.reactivex.Single

interface RemoteEpisodeDataSource {
    fun getEpisodeFromCharacter(episodeUrlList: List<String>): Single<List<Episode>>
}
