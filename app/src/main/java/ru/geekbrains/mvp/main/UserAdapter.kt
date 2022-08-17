package ru.geekbrains.mvp.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.databinding.FragmentUserBinding
import ru.geekbrains.mvp.databinding.ItemUserBinding
import ru.geekbrains.mvp.model.GithubUser

class UserAdapter(
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: GithubUser) {
            val binding = ItemUserBinding.bind(itemView)
            binding.tvUserLogin.text = item.login
            binding.root.setOnClickListener {
                onItemClickListener.onItemClick(item)
            }
        }
    }
}