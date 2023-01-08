package com.platzi.android.rickandmorty.databasemanager.di

import com.platzi.android.rickandmorty.data.datasources.LocalCharacterDataSource
import com.platzi.android.rickandmorty.databasemanager.CharacterRoomDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface BindDatabaseModule {

    @Binds
    fun bindLocalCharacterDataSource(
        CharacterRoomDataSource: CharacterRoomDataSource
    ): LocalCharacterDataSource

}