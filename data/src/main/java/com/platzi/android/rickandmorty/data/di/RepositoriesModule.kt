package com.platzi.android.rickandmorty.data.di

import com.platzi.android.rickandmorty.data.repositories.CharacterRepositoryImpl
import com.platzi.android.rickandmorty.usecases.repositories.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindCharacterRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository

}
