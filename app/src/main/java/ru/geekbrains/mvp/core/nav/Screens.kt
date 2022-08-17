package ru.geekbrains.mvp.core.nav

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.mvp.model.GithubUser
import ru.geekbrains.mvp.user.UserFragment
import ru.geekbrains.mvp.user.displayUser.DisplayUserFragment

class UsersScreen : Screen {
    fun onUsers() = FragmentScreen {UserFragment.newInstance()}
    fun onDisplayUser(user: GithubUser) = FragmentScreen {DisplayUserFragment.newInstance(user)}
}