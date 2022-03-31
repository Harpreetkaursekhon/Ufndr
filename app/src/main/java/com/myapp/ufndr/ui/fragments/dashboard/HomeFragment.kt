package com.myapp.ufndr.ui.fragments.dashboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.myapp.ufndr.R
import com.myapp.ufndr.databinding.FragmentHomeBinding
import com.myapp.ufndr.ui.adapter.CardStackAdapter
import com.yuyakaido.android.cardstackview.*

class HomeFragment : Fragment(), CardStackListener {
    lateinit var layoutManager: CardStackLayoutManager
    var adapter= CardStackAdapter()
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardStackView = view.findViewById<CardStackView>(R.id.stackview)
        binding.ivProfileIcon.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_companyProfileFragment)
        }
        binding.ivFilterIcon.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_bottomSheetFragment)
        }

        layoutManager= CardStackLayoutManager(context, this).apply {
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setOverlayInterpolator(LinearInterpolator())
        }
        cardStackView.layoutManager = layoutManager
        layoutManager.setStackFrom(StackFrom.Top)
        layoutManager.setVisibleCount(3)

        adapter= CardStackAdapter()
        cardStackView.adapter=adapter
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
       when(direction){
           Direction.Left -> {
               adapter.notifyItemRemoved(0)
           }
       }
    }

    override fun onCardRewound() {
        Log.d("TAG","rewound")
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }


}