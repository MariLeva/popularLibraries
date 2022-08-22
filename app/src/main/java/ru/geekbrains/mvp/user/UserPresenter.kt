package ru.geekbrains.mvp.user

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import moxy.MvpPresenter
import ru.geekbrains.mvp.core.nav.UsersScreen
import ru.geekbrains.mvp.model.GithubUser
import ru.geekbrains.mvp.repository.GithubRepository
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class UserPresenter(
    private val repository: GithubRepository,
    private val screen: UsersScreen,
    private val router: Router
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        repository.getUsers()
            .subscribe({
                viewState.initList(it)
                viewState.hideLoading()
            },
                {})
        }


    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun onDisplayUser(user: GithubUser) {
        router.navigateTo(screen.onDisplayUser(user))
    }

}
