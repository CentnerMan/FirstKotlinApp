package ru.vlsv.firstkotlinapp.repositories

import android.os.Handler
import android.os.Looper
import ru.vlsv.firstkotlinapp.entities.Films
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object ImMemoryFilmsRepository : FilmsRepository {

    private val executor: Executor = Executors.newSingleThreadExecutor()

    private val films: ArrayList<Films> = ArrayList<Films>()

    private val handler = Handler(Looper.getMainLooper())

    private fun InMemoryNotesRepository() {
        films.add(Films(UUID.randomUUID().toString(), "Film 1", "Description 1"))
        films.add(Films(UUID.randomUUID().toString(), "Film 2", "Description 2"))
        films.add(Films(UUID.randomUUID().toString(), "Film 3", "Description 3"))
    }

    override fun getAll(callback: Callback<List<Films>>) {
        executor.execute { handler.post { callback.onSuccess(films) } }
    }

    override fun save(title: String, description: String, callback: Callback<Films>) {
        executor.execute {
            handler.post {

                val film = Films(UUID.randomUUID().toString(), title, description)
                films.add(film)
                callback.onSuccess(film)
            }
        }
    }

    override fun update(
        film: Films,
        title: String,
        description: String,
        callback: Callback<Films>
    ) {
        executor.execute {
            handler.post {
                var index = 0
                for (i in films.indices) {
                    if (films.get(i).id.equals(film.id)) {
                        index = i
                        break
                    }
                }
                val editableFilm: Films = films.get(index)
                editableFilm.title = title
                editableFilm.description = description
                callback.onSuccess(editableFilm)
            }
        }
    }

    override fun delete(film: Films, callback: Callback<Void>) {
        executor.execute {
            handler.post {
                films.remove(film)
                callback.onSuccess(null)
            }
        }
    }

}