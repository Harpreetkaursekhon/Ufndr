package com.myapp.ufndr.ui.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentInnerChatBinding

class InnerChatFragment : Fragment() {
lateinit var binding: FragmentInnerChatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_inner_chat, container, false)
        return binding.root
    }
}