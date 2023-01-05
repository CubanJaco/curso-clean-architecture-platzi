package com.platzi.android.rickandmorty.di_test

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    companion object {

        private var retrofitProvider: RetrofitProvider? = null
        private var retrofit: Retrofit? = null

        fun getRetrofitInstance(baseUrl: String): Retrofit {
            if (retrofitProvider == null)
                retrofitProvider = RetrofitProvider()

            if (retrofit == null)
                retrofit = retrofitProvider!!.createRetrofitProvider(baseUrl)

            return retrofit!!
        }

        fun createRetrofitInstance(baseUrl: String): Retrofit {
            if (retrofitProvider == null)
                retrofitProvider = RetrofitProvider()

            retrofit = retrofitProvider!!.createRetrofitProvider(baseUrl)

            return retrofit!!
        }

    }

    private val okHttpClient: OkHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    private fun createRetrofitProvider(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}