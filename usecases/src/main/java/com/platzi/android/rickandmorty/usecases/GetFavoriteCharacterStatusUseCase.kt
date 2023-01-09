package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.usecases.repositories.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.Maybe
import javax.inject.Inject

@ViewModelScoped
class GetFavoriteCharacterStatusUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {

    fun invoke(characterId: Int): Maybe<Boolean> =
        characterRepository.getFavoriteCharacterStatus(characterId)
}
