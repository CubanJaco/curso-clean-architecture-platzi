package com.platzi.android.rickandmorty.data.repositories

import com.platzi.android.rickandmorty.data.datasources.RemoteEpisodeDataSource
import com.platzi.android.rickandmorty.domain.Episode
import com.platzi.android.rickandmorty.usecases.repositories.EpisodeRepository
import io.reactivex.Single

class EpisodeRepositoryImpl(
    private val remoteEpisodeDataSource: RemoteEpisodeDataSource
): EpisodeRepository {

    //region Public Methods

    override fun getEpisodeFromCharacter(episodeUrlList: List<String>): Single<List<Episode>> =
        remoteEpisodeDataSource.getEpisodeFromCharacter(episodeUrlList)

    //endregion
}
