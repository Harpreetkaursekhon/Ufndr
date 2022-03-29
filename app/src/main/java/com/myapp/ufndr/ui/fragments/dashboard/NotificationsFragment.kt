package com.myapp.ufndr.ui.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentNotificationsBinding
import com.myapp.ufndr.model.DataModel
import com.myapp.ufndr.ui.adapter.NotificationAdapter

class NotificationsFragment : Fragment() {
     var adapter= NotificationAdapter(getItemsList())
     lateinit var binding: FragmentNotificationsBinding
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_notifications, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager= LinearLayoutManager(context)
        binding.recycler.layoutManager=layoutManager
        binding.recycler.adapter=adapter

    }
    private fun getItemsList(): ArrayList<DataModel> {
        val list = ArrayList<DataModel>()
        list.add(DataModel.NotificationTypeOne("Dishu", "how are you?", R.mipmap.ic_user_one))
        list.add(DataModel.NotificationTypeOne("Dishu", "how are you?", R.mipmap.ic_user_two))
        list.add(DataModel.NotificationTypeOne("Dishu", "how are you?", R.mipmap.ic_user_one))
        list.add(DataModel.NotificationTypeTwo("Dishu", "how are you?", R.mipmap.ic_user_two))
        list.add(DataModel.NotificationTypeTwo("Dishu", "how are you?", R.mipmap.ic_user_one))
        list.add(DataModel.NotificationTypeTwo("Dishu", "how are you?", R.mipmap.ic_user_two))
        return list
    }
}