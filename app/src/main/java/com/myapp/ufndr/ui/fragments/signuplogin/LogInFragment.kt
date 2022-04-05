package com.myapp.ufndr.ui.fragments.signuplogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.facebook.*
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.Task
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentLogInBinding
import com.myapp.ufndr.ui.interfaces.LogInResultCallback
import com.myapp.ufndr.viewmodel.LogInViewModel
import com.myapp.ufndr.viewmodel.LoginViewModelFactory
import java.lang.Exception

@Suppress("DEPRECATION")
class LogInFragment : Fragment(), LogInResultCallback, GoogleApiClient.OnConnectionFailedListener {
lateinit var binding:FragmentLogInBinding
lateinit var callbackManager: CallbackManager
    private val EMAIL = "email"
    lateinit var googleSignInClient: GoogleSignInClient
    val RC_SIGN_IN = 1

    private val facebookCallback = object : FacebookCallback<LoginResult?> {
        override fun onSuccess(result: LoginResult?) {
            Log.d("MainActivity", "Facebook token: " + result!!.accessToken.token)
            val accessToken = AccessToken.getCurrentAccessToken()
            if(accessToken != null && !accessToken.isExpired){
                findNavController().navigate(R.id.action_logInFragment_to_dashboardFragment)
            }
        }
        override fun onCancel() {
        }

        override fun onError(error: FacebookException?) {
            Log.d("MainActivity", "Facebook token: " + error!!.message)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        FacebookSdk.sdkInitialize(context)
//        AppEventsLogger.activateApp(context)
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_log_in, container, false)
        return binding.root

    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignData(task)
        }
    }

    private fun handleSignData(task: Task<GoogleSignInAccount>) {
        try {
            val googleSignInAccount = task.getResult(ApiException::class.java)
//            val account= GoogleSignIn.getLastSignedInAccount(requireContext())
//            if (account!=null){
//                val name= account.displayName
//                val gname=account.givenName
//                val fname= account.familyName
//                val email= account.email
//                val proifle=account.photoUrl
//            }
        }catch (e:Exception){
            Log.d("exception", e.message.toString())
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance()
            .registerCallback(callbackManager, facebookCallback)
        val googleSignInOptions= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        googleSignInClient = GoogleSignIn.getClient(context ?: return, googleSignInOptions)
        val googleSignInAccount= GoogleSignIn.getLastSignedInAccount(context ?: return)
        binding.ivGoogle.setOnClickListener {
            signIn()
        }

        binding.viewModel= ViewModelProviders.of(this,
            LoginViewModelFactory(this)
        ).get(LogInViewModel::class.java)

        binding.ivFb.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(
                this,
                listOf(EMAIL)
            )
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
    private fun signIn() {
        val intent= googleSignInClient.signInIntent
        startActivityForResult(intent, RC_SIGN_IN)
    }
    override fun success(message: String) {
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }
    override fun error(message: String) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }
    override fun onConnectionFailed(p0: ConnectionResult) {
    }
}