package com.platzi.android.rickandmorty.di_test.containers.implementations

import android.util.Log
import com.platzi.android.rickandmorty.BuildConfig
import com.platzi.android.rickandmorty.di_test.CharacterListViewModelFactory
import com.platzi.android.rickandmorty.di_test.CharacterRequestFactory
import com.platzi.android.rickandmorty.di_test.containers.interfaces.CharacterListFlowContainerAbs
import retrofit2.Retrofit

class CharacterListFlowContainerImpl(retrofit: Retrofit): CharacterListFlowContainerAbs(retrofit) {

    private val TAG = BuildConfig.TAG.ifBlank { this::class.java.simpleName }

    private lateinit var characterRequestFactory: CharacterRequestFactory

    private lateinit var characterListViewModelFactory: CharacterListViewModelFactory

    override fun getCharacterListViewModelFactory(): CharacterListViewModelFactory {
        Log.d(TAG, "getCharacterListViewModelFactory: Creating CharacterListViewModelFactory")

        if (!::characterRequestFactory.isInitialized)
            characterRequestFactory = CharacterRequestFactory(retrofit)

        if (!::characterListViewModelFactory.isInitialized)
            characterListViewModelFactory = CharacterListViewModelFactory(characterRequestFactory)

        Log.d(TAG, "getCharacterListViewModelFactory: CharacterListViewModelFactory created")
        return characterListViewModelFactory
    }

}