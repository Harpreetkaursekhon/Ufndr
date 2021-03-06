package com.myapp.ufndr.ui.fragments.dashboard

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentDashboardBinding

import com.yuyakaido.android.cardstackview.*

class DashboardFragment : Fragment() {
    lateinit var binding: FragmentDashboardBinding

    lateinit var navigationController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setImageDrawable(resources.getDrawable(R.drawable.ic_logo_icon))
        binding.bottomNavigationView.background = null
        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragmentContainerViewChild) as NavHostFragment
        navigationController = navHostFragment.findNavController()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_connection -> {
                    navigationController.navigate(R.id.nav_connection)
                    return@setOnItemSelectedListener true
                }
                R.id.nav_fav -> {
                    navigationController.navigate(R.id.nav_fav)
                    return@setOnItemSelectedListener true
                }
                R.id.nav_chat -> {
                    navigationController.navigate(R.id.nav_chat)
                    return@setOnItemSelectedListener true
                }
                R.id.nav_notify -> {
                    navigationController.navigate(R.id.nav_notify)
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }

    }


}