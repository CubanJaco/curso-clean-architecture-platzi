package com.platzi.android.rickandmorty.data.datasources

import com.platzi.android.rickandmorty.domain.Character
import io.reactivex.Flowable
import io.reactivex.Maybe

interface LocalCharacterDataSource {

    fun getAllFavoriteCharacters(): Flowable<List<Character>>

    fun getFavoriteCharacterStatus(characterId: Int): Maybe<Boolean>

    fun updateFavoriteCharacterStatus(character: Character): Maybe<Boolean>
}