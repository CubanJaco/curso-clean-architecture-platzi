package com.platzi.android.rickandmorty.requestmanager.di

import com.platzi.android.rickandmorty.data.datasources.RemoteCharacterDataSource
import com.platzi.android.rickandmorty.requestmanager.CharacterRetrofitDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface BindAPIModule {

    @Binds
    fun bindRemoteCharacterDataSource(
        characterRetrofitDataSource: CharacterRetrofitDataSource
    ): RemoteCharacterDataSource

}