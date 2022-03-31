package com.myapp.ufndr.ui.fragments.signuplogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.facebook.*
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentLogInBinding

@Suppress("DEPRECATION")
class LogInFragment : Fragment() {
lateinit var binding:FragmentLogInBinding
lateinit var callbackManager: CallbackManager
    private val EMAIL = "email"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        FacebookSdk.sdkInitialize(context)
        AppEventsLogger.activateApp(context)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivFb.setOnClickListener {
            binding.loginButton.setReadPermissions(listOf(EMAIL))
            callbackManager = CallbackManager.Factory.create()
            binding.loginButton.registerCallback(
                callbackManager,
                object : FacebookCallback<LoginResult?> {
                    override fun onSuccess(result: LoginResult?) {
                        Log.d("MainActivity", "Facebook token: " + result!!.accessToken.token)
                        findNavController().navigate(R.id.action_logInFragment_to_dashboardFragment)
                    }

                    override fun onCancel() {
                        TODO("Not yet implemented")
                    }

                    override fun onError(error: FacebookException?) {
                        Log.d("MainActivity", "Facebook token: " + error!!.message)
                    }
                })
            callbackManager = CallbackManager.Factory.create()
            LoginManager.getInstance()
                .registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
                    override fun onSuccess(result: LoginResult?) {
                        val accessToken = AccessToken.getCurrentAccessToken()
                        accessToken != null && !accessToken.isExpired
                    }

                    override fun onError(error: FacebookException?) {
                        TODO("Not yet implemented")
                    }

                    override fun onCancel() {
                        TODO("Not yet implemented")
                    }
                })
        }

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