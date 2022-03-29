package com.myapp.ufndr.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.myapp.ufndr.R
import com.myapp.ufndr.ui.fragments.dashboard.InnerChatFragment

class ChatAdapter: RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    private var name = arrayOf("John", "Lay", "Yanbo", "Louis", "Leo")
    private var msg = arrayOf("How are you?", "How's you going?", "How's you been?", "I message you to..", "I was thinking to have a chat ")
    private var imgcandidate= intArrayOf(R.mipmap.ic_user_one, R.mipmap.ic_user_two, R.mipmap.ic_user_one, R.mipmap.ic_user_two, R.mipmap.ic_user_one)
    private var tvtime= arrayOf("50min","1hour", "3hours","5min","40min")


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imagecandidate = itemView.findViewById<ImageView>(R.id.iv_candidate)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val online = itemView.findViewById<TextView>(R.id.tv_online)
        val msg = itemView.findViewById<TextView>(R.id.tv_msg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.chat_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imagecandidate.setImageResource(imgcandidate[position])
        holder.name.text = name[position]
        holder.online.text = tvtime[position]
        holder.msg.text = msg[position]
        holder.itemView.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_nav_chat_to_innerChatFragment)
        }
    }

    override fun getItemCount(): Int = name.size
}