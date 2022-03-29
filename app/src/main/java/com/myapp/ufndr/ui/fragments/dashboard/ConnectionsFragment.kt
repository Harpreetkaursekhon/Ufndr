package com.myapp.ufndr.ui.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentConnectionsBinding
import com.myapp.ufndr.ui.adapter.ConnectionViewPagerAdapter

class ConnectionsFragment : Fragment() {
    val connectionsArray = arrayOf("Accepted", "Sent")
lateinit var binding: FragmentConnectionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_connections, container, false)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = fragmentManager?.let { ConnectionViewPagerAdapter(it, lifecycle) }
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = connectionsArray[position]
        }.attach()
    }
    }

