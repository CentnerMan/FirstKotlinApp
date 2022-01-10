package ru.vlsv.firstkotlinapp.repositories

interface Callback<T> {
    fun onSuccess(result: T?)
    fun onError(error: Throwable?)
}