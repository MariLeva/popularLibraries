package ru.geekbrains.mvp

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun counterClickButton1(){
        view.setButton1Text(model.next(0).toString())
    }

    fun counterClickButton2(){
        view.setButton2Text(model.next(1).toString())
    }

    fun counterClickButton3(){
        view.setButton3Text(model.next(2).toString())
    }
}