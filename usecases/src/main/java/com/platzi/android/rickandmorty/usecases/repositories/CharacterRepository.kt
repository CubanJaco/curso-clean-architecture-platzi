package com.platzi.android.rickandmorty.usecases.repositories

import com.platzi.android.rickandmorty.domain.Character
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

interface CharacterRepository {

    fun getAllCharacters(page: Int): Single<List<Character>>

    fun getAllFavoriteCharacters(): Flowable<List<Character>>

    fun getFavoriteCharacterStatus(characterId: Int): Maybe<Boolean>

    fun updateFavoriteCharacterStatus(character: Character): Maybe<Boolean>

}