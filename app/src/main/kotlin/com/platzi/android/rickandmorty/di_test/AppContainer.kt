package com.platzi.android.rickandmorty.di_test

import com.platzi.android.rickandmorty.api.APIConstants.BASE_API_URL

class AppContainer {

    private val retrofit = RetrofitProvider.getRetrofitInstance(BASE_API_URL)

    private val characterRequestFactory: CharacterRequestFactory = CharacterRequestFactory(retrofit)
    private val episodeRequestFactory: EpisodeRequestFactory = EpisodeRequestFactory(retrofit)

    val characterListViewModelFactory = CharacterListViewModelFactory(characterRequestFactory)

}