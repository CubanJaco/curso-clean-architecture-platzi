package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.domain.Episode
import com.platzi.android.rickandmorty.usecases.repositories.EpisodeRepository
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.Single
import javax.inject.Inject

@ViewModelScoped
class GetEpisodeFromCharacterUseCase @Inject constructor(
    private val episodeRepository: EpisodeRepository
) {

    fun invoke(episodeUrlList: List<String>): Single<List<Episode>> =
        episodeRepository.getEpisodeFromCharacter(episodeUrlList)
}
