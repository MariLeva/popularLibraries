package ru.geekbrains.mvp.main

import ru.geekbrains.mvp.model.GithubUser

interface OnItemClickListener {
    fun onItemClick(user: GithubUser)
}