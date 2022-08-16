package ru.geekbrains.mvp.repository

import ru.geekbrains.mvp.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
}