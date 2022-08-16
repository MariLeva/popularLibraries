package ru.geekbrains.mvp.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.MainPresenter
import ru.geekbrains.mvp.databinding.ActivityMainBinding
import ru.geekbrains.mvp.model.GithubUser
import ru.geekbrains.mvp.repository.impl.GithubRepositoryImpl
import ru.geekbrains.mvp.user.MainView

class MainActivity : MvpAppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val adapter = UserAdapter()
    private val presenter by  moxyPresenter { MainPresenter(GithubRepositoryImpl()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUsers.setItemViewCacheSize(1)
            rvUsers.adapter = adapter
        }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }
}