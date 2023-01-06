package com.platzi.android.rickandmorty.di_test.containers.interfaces

import com.platzi.android.rickandmorty.di_test.CharacterListViewModelFactory
import retrofit2.Retrofit

interface CharacterListFlowContainer {
    fun getCharacterListViewModelFactory(): CharacterListViewModelFactory
}

abstract class CharacterListFlowContainerAbs(
    protected val retrofit: Retrofit
) : CharacterListFlowContainer {
    abstract override fun getCharacterListViewModelFactory(): CharacterListViewModelFactory
}