package com.myapp.ufndr.ui.fragments.signuplogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentCompanySignUpBinding

class CompanySignUpFragment : Fragment() {
lateinit var binding: FragmentCompanySignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_company_sign_up, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCompanySignup.setOnClickListener {
     //       findNavController().navigate(R.id.action_logInFragment_to_companySignUpFragment)
        }
        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_companySignUpFragment_to_logInFragment)
        }
        binding.ivSetImage.setOnClickListener {
            findNavController().navigate(R.id.action_companySignUpFragment_to_cameraGalleryFragment)
        }
    }
}
