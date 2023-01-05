package com.platzi.android.rickandmorty.api

import com.platzi.android.rickandmorty.di_test.RetrofitProvider
import retrofit2.Retrofit

abstract class BaseRequest<T: Any>(
    val baseUrl: String,
    private var _retrofit: Retrofit?
) {

    // Exponer retrofit como inmutable
    val retrofit: Retrofit?
        get() = _retrofit

    fun setRetrofit(retrofit: Retrofit) {
        if (_retrofit == null)
            _retrofit = retrofit
    }

    inline fun <reified T:Any> getService(): T {

        // Permitir que no se pase por parametro el retrofit para que continue trabajando la app
        if (retrofit == null)
            setRetrofit(RetrofitProvider.getRetrofitInstance(baseUrl))

        return retrofit!!.run {
            create(T::class.java)
        }

    }


}

class CharacterRequest(baseUrl: String, retrofit: Retrofit? = null): BaseRequest<CharacterService>(baseUrl, retrofit)

class EpisodeRequest(baseUrl: String, retrofit: Retrofit? = null): BaseRequest<EpisodeService>(baseUrl, retrofit)