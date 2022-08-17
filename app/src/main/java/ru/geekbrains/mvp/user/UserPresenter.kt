package ru.geekbrains.mvp.user

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.mvp.core.nav.UsersScreen
import ru.geekbrains.mvp.model.GithubUser
import ru.geekbrains.mvp.repository.GithubRepository

class UserPresenter(
    private val repository: GithubRepository,
    private val screen: UsersScreen,
    private val router: Router
): MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressed() : Boolean{
        router.exit()
        return true
    }

    fun onDisplayUser(user: GithubUser){
        router.navigateTo(screen.onDisplayUser(user))
    }
}
