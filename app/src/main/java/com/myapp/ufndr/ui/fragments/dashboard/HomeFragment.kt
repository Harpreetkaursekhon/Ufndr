package com.myapp.ufndr.ui.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
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
        Toast.makeText(context, "drag", Toast.LENGTH_SHORT).show()
    }

    override fun onCardSwiped(direction: Direction?) {
       when(direction){
           Direction.Left -> {
               adapter.notifyItemRemoved(0)
           }
       }
    }

    override fun onCardRewound() {
        Toast.makeText(context, "rewound", Toast.LENGTH_SHORT).show()
    }

    override fun onCardCanceled() {
        Toast.makeText(context, "cancel", Toast.LENGTH_SHORT).show()
    }

    override fun onCardAppeared(view: View?, position: Int) {
        Toast.makeText(context, "appear", Toast.LENGTH_SHORT).show()
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        Toast.makeText(context, "disappear", Toast.LENGTH_SHORT).show()

    }


}