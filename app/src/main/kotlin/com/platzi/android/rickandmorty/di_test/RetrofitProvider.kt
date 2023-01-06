package com.platzi.android.rickandmorty.di_test

import android.os.Build
import android.util.Log
import com.platzi.android.rickandmorty.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class RetrofitProvider {

    companion object {

        private val TAG = BuildConfig.TAG.ifBlank { "RetrofitProvider" }

        private var retrofitProvider: RetrofitProvider? = null
        private var retrofit: Retrofit? = null

        fun getRetrofitInstance(baseUrl: String): Retrofit {
            if (retrofitProvider == null) {
                Log.d(TAG, "getRetrofitInstance: Creating retrofit provider")
                retrofitProvider = RetrofitProvider()
            }

            if (retrofit == null) {
                Log.d(TAG, "getRetrofitInstance: Creating retrofit")
                retrofit = retrofitProvider!!.createRetrofitProvider(baseUrl)
            }

            Log.d(TAG, "getRetrofitInstance: Retrofit instance created")

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