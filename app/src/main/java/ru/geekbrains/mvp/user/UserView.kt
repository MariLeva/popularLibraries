package ru.geekbrains.mvp.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.mvp.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView: MvpView {
    fun initList(list: List<GithubUser>)
    fun showLoading()
    fun hideLoading()
}