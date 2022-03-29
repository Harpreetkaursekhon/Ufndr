package com.myapp.ufndr.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.myapp.ufndr.R

class FavouriteAdapter: RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {
    private var imglike= intArrayOf(R.mipmap.ic_close_icon,R.mipmap.ic_close_icon,R.mipmap.ic_close_icon)
    private var imgclose= intArrayOf(R.mipmap.ic_fav_deselect_icon,R.mipmap.ic_fav_deselect_icon, R.mipmap.ic_fav_deselect_icon)
    private var imgcandidate= intArrayOf(
        R.mipmap.ic_round_front_face,
        R.mipmap.ic_round_front_face,
        R.mipmap.ic_round_front_face)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val ivlike= itemView.findViewById<ImageView>(R.id.iv_like)
        val ivclose= itemView.findViewById<ImageView>(R.id.iv_close)
        val ivcandidate= itemView.findViewById<ImageView>(R.id.iv_profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.favourite_item_view,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.ivcandidate.setImageResource(imgcandidate[position])
        holder.ivclose.setImageResource(imgclose[position])
        holder.ivlike.setImageResource(imglike[position])
    }

    override fun getItemCount(): Int = imgcandidate.size
}