package com.myapp.ufndr.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.myapp.ufndr.model.LoginValidationModel
import com.myapp.ufndr.ui.interfaces.LogInResultCallback

class LogInViewModel(private val listener: LogInResultCallback): ViewModel(){

    private val loginValidationModel: LoginValidationModel = LoginValidationModel("","")

    val emailTextWatcher: TextWatcher
    get() = object : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
            loginValidationModel.setEmail(p0.toString())
        }

    }

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {
                loginValidationModel.setPassword(p0.toString())
            }

        }

    fun onLoginClicked(v: View){
        var logincode:Int = loginValidationModel.isDataValid()
        if (logincode==0)
            listener.error("Email must not be null")
        else if (logincode==1)
            listener.error("wrong email pattern")
        else if (logincode==2)
            listener.success("Password length must be greater than six")
        else
            listener.success("Login successful")
    }
}