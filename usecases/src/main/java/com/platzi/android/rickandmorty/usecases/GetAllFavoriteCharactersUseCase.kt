package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.usecases.repositories.CharacterRepository
import io.reactivex.Flowable

class GetAllFavoriteCharactersUseCase(
    private val characterRepository: CharacterRepository
) {

    fun invoke(): Flowable<List<Character>> = characterRepository.getAllFavoriteCharacters()
}