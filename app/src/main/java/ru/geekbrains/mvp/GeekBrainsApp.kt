package ru.geekbrains.mvp

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class GeekBrainsApp: Application() {
    private val cicerone : Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigationHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object{
        lateinit var instance: GeekBrainsApp
    }
}