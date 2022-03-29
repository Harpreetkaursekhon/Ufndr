package com.myapp.ufndr.ui.fragments.signuplogin

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {
lateinit var binding:FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_log_in, container, false)
        return binding.root
        emailFocusListener()
        passwordFocusListener()
    }

    private fun emailFocusListener() {
        binding.edEmail.setOnFocusChangeListener{_, focused->
            if(!focused){
                binding.tlEmailContainer.helperText= validEmail()
            }

        }
    }
    private fun validEmail(): String? {
        val email= binding.edEmail.text.toString()
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "invalid email address"
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.edPassword.setOnFocusChangeListener{_, focused->
            if(!focused){
                binding.tlPasswordContainer.helperText= validPassword()
            }

        }
    }

    private fun validPassword(): String? {
        val password= binding.edPassword.text.toString()
        if (password.length < 8 && password.isNullOrEmpty()){
            return "enter valid password"
        }
        if(!password.matches(".*[A-Z].*".toRegex())){
        return "must contain 1 uppercase "
        }
        if(!password.matches(".*[a-z].*".toRegex())){
            return "must contain 1 lowercase "
        }
        if(!password.matches(".*[#$%&._%-+].*".toRegex())){
            return "must contain 1 special character "
        }
        if(!password.matches(".*[0-9].*".toRegex())){
            return "must contain 1 number "
        }
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_dashboardFragment)
     //   submitForm()
        }
        binding.tvClickToSignup.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_companySignUpFragment)
        }
        binding.tvForgotPass.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_forgotFragment)
        }
    }

//    private fun submitForm() {
//        binding.tlEmailContainer.helperText== validEmail()
//        binding.tlPasswordContainer.helperText== validPassword()
//
//        val validEmail=binding.tlEmailContainer.helperText== null
//        val validPassword=binding.tlPasswordContainer.helperText== null
//
//        if(validEmail && validPassword)
//            resetForm()
//    }

    private fun resetForm() {
        binding.edEmail.text=null
        binding.edPassword.text=null
    }

}