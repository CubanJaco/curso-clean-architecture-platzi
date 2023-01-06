package com.platzi.android.rickandmorty.di_test

import android.util.Log
import com.platzi.android.rickandmorty.BuildConfig
import com.platzi.android.rickandmorty.api.APIConstants.BASE_API_URL
import com.platzi.android.rickandmorty.api.CharacterRequest
import com.platzi.android.rickandmorty.api.EpisodeRequest
import com.platzi.android.rickandmorty.di_test.containers.interfaces.Factory
import com.platzi.android.rickandmorty.presentation.CharacterListViewModel
import retrofit2.Retrofit

// Factory for CharacterListViewModel.
// Since CharacterListViewModel depends on CharacterRequest, in order to create instances of
// CharacterListViewModel, you need an instance of CharacterRequest that you pass as a parameter.
class CharacterListViewModelFactory(private val characterRequest: CharacterRequestFactory): Factory<CharacterListViewModel> {

    private val TAG = BuildConfig.TAG.ifBlank { this::class.java.simpleName }

    override fun create(): CharacterListViewModel {
        Log.d(TAG, "create: Creating CharacterListViewModel")
        return CharacterListViewModel(characterRequest.create())
    }

}

class CharacterRequestFactory(private val retrofit: Retrofit): Factory<CharacterRequest> {

    private val TAG = BuildConfig.TAG.ifBlank { this::class.java.simpleName }

    override fun create(): CharacterRequest {
        Log.d(TAG, "create: Creating CharacterRequest")
        return CharacterRequest(BASE_API_URL, retrofit)
    }

}

class EpisodeRequestFactory(private val retrofit: Retrofit): Factory<EpisodeRequest> {

    private val TAG = BuildConfig.TAG.ifBlank { this::class.java.simpleName }

    override fun create(): EpisodeRequest {
        Log.d(TAG, "create: Creating EpisodeRequest")
        return EpisodeRequest(BASE_API_URL, retrofit)
    }

}