package com.myapp.ufndr.ui.fragments.swipeviews

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daprlabs.cardstack.SwipeDeck
import com.myapp.ufndr.R
import com.myapp.ufndr.ui.adapter.CardStackAdapter
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.Direction

class HomeSwipeProfileFragment : Fragment() {
lateinit var cardStackAdapter: CardStackAdapter
lateinit var cardStackLayoutManager: CardStackLayoutManager
    lateinit var adapter: CardStackAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_swipe_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var stackView = view.findViewById<SwipeDeck>(R.id.swipe_deck)
        cardStackLayoutManager = CardStackLayoutManager(context)
        adapter = CardStackAdapter()
      //  stackView.setAdapter(adapter)

        stackView.setEventCallback(object : SwipeDeck.SwipeEventCallback{
            override fun cardSwipedLeft(position: Int) {
                TODO("Not yet implemented")
            }

            override fun cardSwipedRight(position: Int) {
                TODO("Not yet implemented")
            }

            override fun cardsDepleted() {
                TODO("Not yet implemented")
            }

            override fun cardActionDown() {
                TODO("Not yet implemented")
            }

            override fun cardActionUp() {
                TODO("Not yet implemented")
            }

        })

    }
}


