package com.platzi.android.rickandmorty.databasemanager.di

import android.content.Context
import com.platzi.android.rickandmorty.databasemanager.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
class ProviderDatabaseModule {

    @Provides
    fun provideCharacterDatabase(
        @ApplicationContext context: Context
    ): CharacterDatabase {
        return CharacterDatabase.getDatabase(context)
    }

}