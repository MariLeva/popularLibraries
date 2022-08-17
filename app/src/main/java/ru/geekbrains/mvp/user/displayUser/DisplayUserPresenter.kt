package ru.geekbrains.mvp.user.displayUser

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.mvp.core.nav.UsersScreen
import ru.geekbrains.mvp.model.GithubUser

class DisplayUserPresenter(
    private val user: GithubUser,
    private val screen: UsersScreen,
    private val router: Router
): MvpPresenter<DisplayUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.displayUser(user)
    }

    fun onBackPressed() : Boolean{
        router.replaceScreen(screen.onUsers())
        return true
    }
}