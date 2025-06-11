package com.example.lab45

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewUsername: TextView = itemView.findViewById(R.id.textViewUsername)
        val textViewFullname: TextView = itemView.findViewById(R.id.textViewFullname)
        val textViewEmail: TextView = itemView.findViewById(R.id.textViewEmail)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.textViewUsername.text = user.username
        holder.textViewFullname.text = user.fullname
        holder.textViewEmail.text = user.email
    }
    
    override fun getItemCount(): Int = users.size
}