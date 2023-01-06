package com.platzi.android.rickandmorty.di_test.containers.implementations

import android.util.Log
import com.platzi.android.rickandmorty.BuildConfig
import com.platzi.android.rickandmorty.api.APIConstants
import com.platzi.android.rickandmorty.di_test.RetrofitProvider
import com.platzi.android.rickandmorty.di_test.containers.interfaces.AppContainer
import com.platzi.android.rickandmorty.di_test.containers.interfaces.CharacterListFlowContainer

class AppContainerImpl : AppContainer {

    private val TAG = BuildConfig.TAG.ifBlank { this::class.java.simpleName }

    // La instancia de retrofit sera la misma para cada flujo
    private val retrofit = RetrofitProvider.getRetrofitInstance(APIConstants.BASE_API_URL)

    private var characterListFlowContainer: CharacterListFlowContainer? = null

    override fun getCharacterListFlowContainer(): CharacterListFlowContainer {
        Log.d(TAG, "getCharacterListFlowContainer: Creating CharacterListFlowContainer")
        if (characterListFlowContainer == null)
            characterListFlowContainer = CharacterListFlowContainerImpl(retrofit)

        Log.d(TAG, "getCharacterListFlowContainer: CharacterListFlowContainer created")
        return characterListFlowContainer!!
    }

    override fun clearCharacterListFlowContainer() {
        characterListFlowContainer = null
    }

}