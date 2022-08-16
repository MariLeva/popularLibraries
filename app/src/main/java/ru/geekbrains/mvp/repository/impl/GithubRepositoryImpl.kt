package ru.geekbrains.mvp.repository.impl

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

    override fun getUsers(): List<GithubUser> {
        return repositories
    }


}