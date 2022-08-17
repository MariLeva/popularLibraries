package ru.geekbrains.mvp.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.GeekBrainsApp
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.core.BackPressedListener
import ru.geekbrains.mvp.core.nav.UsersScreen
import ru.geekbrains.mvp.databinding.ActivityMainBinding
import ru.geekbrains.mvp.model.GithubUser
import ru.geekbrains.mvp.repository.impl.GithubRepositoryImpl

class MainActivity : MvpAppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val navigator = AppNavigator(this, R.id.containerMain)

    private val presenter by  moxyPresenter { MainPresenter(UsersScreen(), GeekBrainsApp.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        GeekBrainsApp.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        GeekBrainsApp.instance.navigationHolder.setNavigator(navigator)
        super.onPause()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is BackPressedListener && currentFragment.onBackPressed()){
                return
            }
        }
        presenter.onBackPressed()
    }
}