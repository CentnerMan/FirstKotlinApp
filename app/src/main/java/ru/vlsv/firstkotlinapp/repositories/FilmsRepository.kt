package ru.vlsv.firstkotlinapp.repositories

import ru.vlsv.firstkotlinapp.entities.Films

interface FilmsRepository {
    fun getAll(callback: Callback<List<Films>>)
    fun save(title: String, description: String, callback: Callback<Films>)
    fun update(film: Films, title: String, description: String, callback: Callback<Films>)
    fun delete(film: Films, callback: Callback<Void>)
}