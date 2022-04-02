package com.myapp.ufndr.ui.fragments.signuplogin

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentCandidateSignUpBinding

class CandidateSignUpFragment : Fragment() {
 lateinit var binding:FragmentCandidateSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_candidate_sign_up, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popupDialog()
    }

    private fun popupDialog() {
        var popupdialog= context?.let { Dialog(it) }
        popupdialog?.setCancelable(false)
        popupdialog?.setContentView(R.layout.fragment_camera_gallery)
        popupdialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var close= popupdialog?.findViewById<ImageView>(R.id.ivclose)
        close?.setOnClickListener {
            popupdialog?.dismiss()
        }
        var layout= popupdialog?.findViewById<LinearLayout>(R.id.lin_one)
        layout?.setOnClickListener {

        }
    }

}