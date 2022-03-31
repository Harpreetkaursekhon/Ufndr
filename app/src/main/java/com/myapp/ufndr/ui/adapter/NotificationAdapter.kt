package com.myapp.ufndr.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapp.ufndr.R
import com.myapp.ufndr.model.DataModel

class NotificationAdapter(private val items: ArrayList<DataModel>) :
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    sealed class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView) {

        class NotifyTypeOneViewHolder(private val itemView: View) : ViewHolder(itemView) {
            fun bind(typeOne: DataModel.NotificationTypeOne) {
                val name = itemView.findViewById<TextView>(R.id.tv_name)
                val message = itemView.findViewById<TextView>(R.id.tv_msg)
                val image = itemView.findViewById<ImageView>(R.id.iv_candidate_one)
            }
        }

        class NotifyTypeTwoViewHolder(private val itemView: View) : ViewHolder(itemView) {
            fun bind(typeOne: DataModel.NotificationTypeTwo) {
                val name = itemView.findViewById<TextView>(R.id.tv_name_two)
                val message = itemView.findViewById<TextView>(R.id.tv_msg_two)
                val image = itemView.findViewById<ImageView>(R.id.iv_candidate_two)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            R.layout.notification_item_one -> ViewHolder.NotifyTypeOneViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.notification_item_one, parent, false)
            )
            R.layout.notification_item_two -> ViewHolder.NotifyTypeTwoViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.notification_item_two, parent, false)
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder.NotifyTypeOneViewHolder -> holder.bind(items[position] as DataModel.NotificationTypeOne)
            is ViewHolder.NotifyTypeTwoViewHolder -> holder.bind(items[position] as DataModel.NotificationTypeTwo)

        }
    }
    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is DataModel.NotificationTypeOne -> R.layout.notification_item_one
            is DataModel.NotificationTypeTwo -> R.layout.notification_item_two
        }
    }

}