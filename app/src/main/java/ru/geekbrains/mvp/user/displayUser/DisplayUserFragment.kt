package ru.geekbrains.mvp.user.displayUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.GeekBrainsApp
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.core.BackPressedListener
import ru.geekbrains.mvp.core.nav.UsersScreen
import ru.geekbrains.mvp.databinding.FragmentDisplayUserBinding
import ru.geekbrains.mvp.main.UserAdapter
import ru.geekbrains.mvp.model.GithubUser


class DisplayUserFragment : MvpAppCompatFragment(), DisplayUserView, BackPressedListener {
    private lateinit var paramLogin: GithubUser
    private var binding: FragmentDisplayUserBinding? = null

    private val presenter by moxyPresenter {
        DisplayUserPresenter(
            paramLogin,
            UsersScreen(),
            GeekBrainsApp.instance.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentDisplayUserBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayUser(paramLogin)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(user: GithubUser) =
            DisplayUserFragment().apply {
                arguments = Bundle().apply {
                    paramLogin = user
                }
            }
    }

    override fun onBackPressed() = presenter.onBackPressed()


    override fun displayUser(user: GithubUser) {
        binding?.tvUserName?.text = user.login
    }
}