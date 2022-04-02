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
//        FacebookSdk.sdkInitialize(context)
//        AppEventsLogger.activateApp(context)
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_log_in, container, false)
        return binding.root

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
        }
        binding.tvClickToSignup.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_candidateSignUpFragment)
        }
        binding.tvTermsService.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_servicesTermsFragment)
        }
        binding.tvPolicy.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_privacyPolicyFragment)
        }
    }

}