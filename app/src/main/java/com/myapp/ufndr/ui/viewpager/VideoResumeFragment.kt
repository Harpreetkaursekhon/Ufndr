package com.myapp.ufndr.ui.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.myapp.ufndr.R
import com.myapp.ufndr.base.VideoType
import com.myapp.ufndr.databinding.FragmentVideoResumeBinding
import com.myapp.ufndr.ui.adapter.ViewPagerAdapter

class VideoResumeFragment : Fragment() {
lateinit var binding: FragmentVideoResumeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_video_resume, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val video= listOf(VideoType(R.mipmap.ic_video_resume_img,"Create a video resume or \n recruitment video"),
            VideoType(R.mipmap.ic_perfect_team_img,"Find the perfect team or \n colleagues"),
            VideoType(R.mipmap.ic_video_resume_img,"Find your dream job or find the \n perfect applicant")
        )
        binding.btnNextVideoResume.setOnClickListener {
            val position = binding.viewpager2.currentItem+1
            if(position==3){
                findNavController().navigate(R.id.action_videoResumeFragment_to_signInAsFragment)
            }else{
                binding.viewpager2.setCurrentItem(position)
            }
        }
        binding.tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_videoResumeFragment_to_signInAsFragment)
        }


        val adapter= ViewPagerAdapter(video)
        binding.viewpager2.adapter=adapter

        binding.viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun equals(other: Any?): Boolean {
                    return super.equals(other)
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    changeColor()
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    changeColor()
                    super.onPageScrollStateChanged(state)
                }
            })

        }
                private fun changeColor() {
                    when (binding.viewpager2.currentItem) {
                        0 -> {
                            context?.resources?.let { binding.iv1.setBackgroundColor(it?.getColor(R.color.main_color)) }
                            context?.resources?.let { binding.iv2.setBackgroundColor(it?.getColor(R.color.black)) }
                            context?.resources?.let { binding.iv3.setBackgroundColor(it?.getColor(R.color.black)) }
                        }
                        1 -> {
                            context?.resources?.let { binding.iv1.setBackgroundColor(it?.getColor(R.color.black)) }
                            context?.resources?.let { binding.iv2.setBackgroundColor(it?.getColor(R.color.main_color)) }
                            context?.resources?.let { binding.iv3.setBackgroundColor(it?.getColor(R.color.black)) }
                        }
                        2 -> {
                            context?.resources?.let { binding.iv1.setBackgroundColor(it?.getColor(R.color.black)) }
                            context?.resources?.let { binding.iv2.setBackgroundColor(it?.getColor(R.color.black)) }
                            context?.resources?.let { binding.iv3.setBackgroundColor(it?.getColor(R.color.main_color)) }
                        }

                    }
                }
}