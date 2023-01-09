package com.platzi.android.rickandmorty.requestmanager.di

import com.platzi.android.rickandmorty.data.datasources.RemoteCharacterDataSource
import com.platzi.android.rickandmorty.data.datasources.RemoteEpisodeDataSource
import com.platzi.android.rickandmorty.requestmanager.CharacterRetrofitDataSource
import com.platzi.android.rickandmorty.requestmanager.EpisodeRetrofitDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface BindAPIModule {

    @Binds
    fun bindRemoteCharacterDataSource(
        characterRetrofitDataSource: CharacterRetrofitDataSource
    ): RemoteCharacterDataSource

    @Binds
    fun bindRemoteEpisodeDataSource(
        episodeRetrofitDataSource: EpisodeRetrofitDataSource
    ): RemoteEpisodeDataSource

}