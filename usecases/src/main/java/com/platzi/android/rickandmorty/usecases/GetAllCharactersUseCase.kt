package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.usecases.repositories.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.Single
import javax.inject.Inject

@ViewModelScoped
class GetAllCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {

    fun invoke(currentPage: Int): Single<List<Character>> =
        characterRepository.getAllCharacters(currentPage)
}