package ru.geekbrains.mvp.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.databinding.FragmentUserBinding
import ru.geekbrains.mvp.main.UserAdapter
import ru.geekbrains.mvp.model.GithubUser


class UserFragment : MvpAppCompatFragment(), MainView {

    private lateinit var viewBinding: FragmentUserBinding

    private val adapter = UserAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(): UserFragment{
            return UserFragment()
        }
    }

    override fun initList(list: List<GithubUser>) {
        TODO("Not yet implemented")
    }
}