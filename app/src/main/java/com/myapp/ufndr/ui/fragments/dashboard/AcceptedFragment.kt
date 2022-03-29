package com.myapp.ufndr.ui.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentAcceptedBinding
import com.myapp.ufndr.ui.adapter.AcceptedAdapter

class AcceptedFragment : Fragment() {
lateinit var binding: FragmentAcceptedBinding
private var adapter= AcceptedAdapter()
    lateinit var layoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_accepted, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager= GridLayoutManager(context, 2,GridLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager=layoutManager
        binding.recyclerview.adapter=adapter
    }

}