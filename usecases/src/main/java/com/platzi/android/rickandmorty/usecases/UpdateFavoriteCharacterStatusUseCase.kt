package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.usecases.repositories.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.Maybe
import javax.inject.Inject

@ViewModelScoped
class UpdateFavoriteCharacterStatusUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {

    fun invoke(character: Character): Maybe<Boolean> =
        characterRepository.updateFavoriteCharacterStatus(character)
}
