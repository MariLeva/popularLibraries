package ru.geekbrains.mvp.repository

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.mvp.model.GithubUser

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
}