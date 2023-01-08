package com.platzi.android.rickandmorty.requestmanager.di

import com.platzi.android.rickandmorty.requestmanager.APIConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ProviderAPIModule {

    @BaseUrlQualifier
    @Provides
    fun provideBaseUrl(): String = APIConstants.BASE_API_URL

}