package com.platzi.android.rickandmorty.data.repositories

import com.platzi.android.rickandmorty.data.datasources.RemoteEpisodeDataSource
import com.platzi.android.rickandmorty.domain.Episode
import com.platzi.android.rickandmorty.usecases.repositories.EpisodeRepository
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.Single
import javax.inject.Inject

@ViewModelScoped
class EpisodeRepositoryImpl @Inject constructor(
    private val remoteEpisodeDataSource: RemoteEpisodeDataSource
) : EpisodeRepository {

    //region Public Methods

    override fun getEpisodeFromCharacter(episodeUrlList: List<String>): Single<List<Episode>> =
        remoteEpisodeDataSource.getEpisodeFromCharacter(episodeUrlList)

    //endregion
}
