package com.myapp.ufndr.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapp.ufndr.R
import com.myapp.ufndr.base.VideoType

class ViewPagerAdapter(val videoType: List<VideoType>): RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val img= itemView.findViewById<ImageView>(R.id.img)
        val content=itemView.findViewById<TextView>(R.id.tv_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.img.setImageResource(videoType[position].images)
        holder.content.text= videoType[position].content
    }

    override fun getItemCount(): Int = videoType.size

}