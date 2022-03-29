package com.myapp.ufndr.ui.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentPerfectTeamBinding

class PerfectTeamFragment : Fragment() {
lateinit var binding: FragmentPerfectTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_perfect_team, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPerfectTeam.setOnClickListener {
            findNavController().navigate(R.id.action_perfectTeamFragment_to_dreamJobFragment)
        }
        binding.tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_perfectTeamFragment_to_signInAsFragment)
        }
    }
}