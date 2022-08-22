package ru.geekbrains.mvp.repository.impl

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.mvp.model.GithubUser
import ru.geekbrains.mvp.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }
    }


}