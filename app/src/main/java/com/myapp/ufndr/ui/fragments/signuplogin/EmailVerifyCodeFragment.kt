package com.myapp.ufndr.ui.fragments.signuplogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentEmailVerifyCodeBinding
import com.myapp.ufndr.databinding.FragmentForgotPasswordBinding

class EmailVerifyCodeFragment : Fragment() {
    lateinit var binding:   FragmentEmailVerifyCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_email_verify_code, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnVerify.setOnClickListener {
            findNavController().navigate(R.id.action_emailVerifyCodeFragment_to_newPasswordFragment)
        }
    }

}