package com.platzi.android.rickandmorty

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.platzi.android.rickandmorty.di_test.AppContainer

class RickAndMortyPlatziApp: Application() {

    val appContainer = AppContainer()

    //region Override Methods & Callbacks

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    //endregion

}
