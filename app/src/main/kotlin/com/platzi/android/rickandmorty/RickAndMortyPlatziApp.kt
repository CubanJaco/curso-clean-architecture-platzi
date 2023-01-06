package com.platzi.android.rickandmorty

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.platzi.android.rickandmorty.di_test.containers.implementations.AppContainerImpl
import com.platzi.android.rickandmorty.di_test.containers.interfaces.AppContainer

class RickAndMortyPlatziApp: Application() {

    val appContainer = AppContainerImpl()

    //region Override Methods & Callbacks

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    //endregion

}
