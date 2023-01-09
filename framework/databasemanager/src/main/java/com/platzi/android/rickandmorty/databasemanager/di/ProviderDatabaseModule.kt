package com.platzi.android.rickandmorty.databasemanager.di

import android.content.Context
import com.platzi.android.rickandmorty.databasemanager.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProviderDatabaseModule {

    @Singleton
    @Provides
    fun provideCharacterDatabase(
        @ApplicationContext context: Context
    ): CharacterDatabase {
        return CharacterDatabase.getDatabase(context)
    }

}