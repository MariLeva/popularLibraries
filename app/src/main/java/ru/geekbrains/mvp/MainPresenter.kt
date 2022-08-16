package ru.geekbrains.mvp

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.mvp.repository.GithubRepository
import ru.geekbrains.mvp.user.MainView

class MainPresenter(
    private val repository: GithubRepository
): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }
}