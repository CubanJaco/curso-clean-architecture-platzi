package com.platzi.android.rickandmorty.data.repositories

import com.platzi.android.rickandmorty.data.datasources.LocalCharacterDataSource
import com.platzi.android.rickandmorty.data.datasources.RemoteCharacterDataSource
import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.usecases.repositories.CharacterRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

class CharacterRepositoryImpl(
    private val remoteCharacterDataSource: RemoteCharacterDataSource,
    private val localCharacterDataSource: LocalCharacterDataSource
): CharacterRepository {

    //region Public Methods

    override fun getAllCharacters(page: Int): Single<List<Character>> =
        remoteCharacterDataSource.getAllCharacters(page)

    override fun getAllFavoriteCharacters(): Flowable<List<Character>> =
        localCharacterDataSource.getAllFavoriteCharacters()

    override fun getFavoriteCharacterStatus(characterId: Int): Maybe<Boolean> =
        localCharacterDataSource.getFavoriteCharacterStatus(characterId)

    override fun updateFavoriteCharacterStatus(character: Character): Maybe<Boolean> =
        localCharacterDataSource.updateFavoriteCharacterStatus(character)

    //endregion
}