package ru.geekbrains.mvp.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.mvp.core.nav.UsersScreen

class MainPresenter(
    private val screen: UsersScreen,
    private val router: Router
): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.onUsers())
    }

    fun onBackPressed(){
        router.exit()
    }
}