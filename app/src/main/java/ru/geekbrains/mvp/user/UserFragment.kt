package ru.geekbrains.mvp.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.GeekBrainsApp
import ru.geekbrains.mvp.core.BackPressedListener
import ru.geekbrains.mvp.core.nav.UsersScreen
import ru.geekbrains.mvp.databinding.FragmentUserBinding
import ru.geekbrains.mvp.main.OnItemClickListener
import ru.geekbrains.mvp.main.UserAdapter
import ru.geekbrains.mvp.model.GithubUser
import ru.geekbrains.mvp.repository.impl.GithubRepositoryImpl


class UserFragment : MvpAppCompatFragment(), UserView, BackPressedListener, OnItemClickListener{

    private lateinit var viewBinding: FragmentUserBinding

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), UsersScreen(), GeekBrainsApp.instance.router)
    }
    private val adapter = UserAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            rvUsers.layoutManager = LinearLayoutManager(requireContext())
            rvUsers.adapter = adapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): UserFragment{
            return UserFragment()
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun showLoading() {
        viewBinding.loadingLayout.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        viewBinding.loadingLayout.visibility = View.GONE
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun onItemClick(user: GithubUser) {
        presenter.onDisplayUser(user)
    }

}