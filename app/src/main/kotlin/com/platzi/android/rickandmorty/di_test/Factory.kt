package com.platzi.android.rickandmorty.di_test

import com.platzi.android.rickandmorty.api.APIConstants.BASE_API_URL
import com.platzi.android.rickandmorty.api.CharacterRequest
import com.platzi.android.rickandmorty.api.EpisodeRequest
import com.platzi.android.rickandmorty.presentation.CharacterListViewModel
import retrofit2.Retrofit

// Definition of a Factory interface with a function to create objects of a type
interface Factory<T> {
    fun create(): T
}

// Factory for CharacterListViewModel.
// Since CharacterListViewModel depends on CharacterRequest, in order to create instances of
// CharacterListViewModel, you need an instance of CharacterRequest that you pass as a parameter.
class CharacterListViewModelFactory(private val characterRequest: CharacterRequestFactory): Factory<CharacterListViewModel> {

    override fun create(): CharacterListViewModel {
        return CharacterListViewModel(characterRequest.create())
    }

}

class CharacterRequestFactory(private val retrofit: Retrofit): Factory<CharacterRequest> {

    override fun create(): CharacterRequest {
        return CharacterRequest(BASE_API_URL/*, retrofit*/)
    }

}

class EpisodeRequestFactory(private val retrofit: Retrofit): Factory<EpisodeRequest> {

    override fun create(): EpisodeRequest {
        return EpisodeRequest(BASE_API_URL/*, retrofit*/)
    }

}