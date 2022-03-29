package com.myapp.ufndr.ui.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentChatBinding
import com.myapp.ufndr.ui.adapter.ChatAdapter

class ChatFragment : Fragment() {
lateinit var binding: FragmentChatBinding
private var chatAdapter= ChatAdapter()
lateinit var layoutManager:LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_chat, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager= LinearLayoutManager(context)
        binding.recycler.layoutManager=layoutManager
        binding.recycler.adapter=chatAdapter

    }

}