package ru.geekbrains.mvp.jpgToPng

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface FileView: MvpView {
    fun loadingFile()
    fun showLoading()
    fun hideLoading()
}