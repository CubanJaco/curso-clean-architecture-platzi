package com.platzi.android.rickandmorty.di_test.containers.interfaces

// Definition of a Factory interface with a function to create objects of a type
interface Factory<T> {
    fun create(): T
}