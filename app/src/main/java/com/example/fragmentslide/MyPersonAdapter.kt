package com.example.fragmentslide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

data class User(val name: String, val gender: String, val birth: Long, val imageView: Int)

class MyPersonAdapter() : ListAdapter<User, UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)  //返回UserViewHolder對象
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }
}
class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    private val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)
    private val birthTextView: TextView = itemView.findViewById(R.id.birthTextView)
    private val imageview: ImageView = itemView.findViewById(R.id.imageView)

    fun bind(user: User) {
        nameTextView.text = user.name
        genderTextView.text = user.gender
        birthTextView.text = user.birth.toString()
        imageview.setImageResource(user.imageView)
    }
}

class UserDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.name == newItem.name
    // oldItem.gender == newItem.gender && oldItem.birth == newItem.birth
    // areItemsThsSame 用來判斷兩個items 是否一樣。
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
