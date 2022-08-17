package ru.geekbrains.mvp.user.displayUser

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.mvp.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface DisplayUserView: MvpView {
    fun displayUser(user: GithubUser)
}