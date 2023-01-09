package com.platzi.android.rickandmorty.data.di

import com.platzi.android.rickandmorty.data.repositories.CharacterRepositoryImpl
import com.platzi.android.rickandmorty.data.repositories.EpisodeRepositoryImpl
import com.platzi.android.rickandmorty.usecases.repositories.CharacterRepository
import com.platzi.android.rickandmorty.usecases.repositories.EpisodeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindCharacterRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository

    @Binds
    fun bindEpisodeRepository(
        episodeRepositoryImpl: EpisodeRepositoryImpl
    ): EpisodeRepository

}
