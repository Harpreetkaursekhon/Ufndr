package com.myapp.ufndr.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.myapp.ufndr.R

class CardStackAdapter : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {
    private var name = arrayOf("John", "Nathan", "Peter", "Rose", "Lay", "Yanbo", "Louis", "Leo")
    private var title = arrayOf(
        "IT",
        "UX",
        "IOS",
        "Networking",
        "Computers",
        "Accounts",
        "Medical",
        "Cyber security")
    private var img = intArrayOf(
        R.drawable.ic_login_bg,
        R.drawable.ic_login_bg,
        R.drawable.ic_login_bg,
        R.drawable.ic_login_bg,
        R.drawable.ic_login_bg,
        R.drawable.ic_login_bg,
        R.drawable.ic_login_bg,
        R.drawable.ic_login_bg)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.iv_image)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val city = itemView.findViewById<TextView>(R.id.tv_field)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardStackAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stack_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardStackAdapter.ViewHolder, position: Int) {
        holder.image.setImageResource(img[position])
        holder.name.text = name[position]
        holder.city.text = title[position]
        holder.itemView.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_home_to_job_seeker_profile)
        }
    }

    override fun getItemCount(): Int = img.size
}
