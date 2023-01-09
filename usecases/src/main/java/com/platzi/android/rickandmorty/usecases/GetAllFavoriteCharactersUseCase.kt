package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.usecases.repositories.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.Flowable
import javax.inject.Inject

@ViewModelScoped
class GetAllFavoriteCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    fun invoke(): Flowable<List<Character>> = characterRepository.getAllFavoriteCharacters()
}