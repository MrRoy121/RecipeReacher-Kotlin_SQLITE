package com.example.rr


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.rr.fragments.pizzaFrag
import com.example.rr.fragments.saladFrag
import com.example.rr.fragments.spaghettiFrag

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return spaghettiFrag()
            }
            1 -> {
                return saladFrag()
            }
            2 -> {
                return pizzaFrag()
            }
            else -> {
                return spaghettiFrag()
            }
        }
    }

}