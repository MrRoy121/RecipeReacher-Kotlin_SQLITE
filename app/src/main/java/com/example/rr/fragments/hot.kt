package com.example.rr.fragments

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.rr.PageAdapter
import com.example.rr.R

class hot : Fragment() {

    private val sharedPrefFile = "user"
    private lateinit var name: TextView
    private lateinit var fav: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.fragment_hot, container, false)
        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        val viewPager = v.findViewById<ViewPager>(R.id.viewpager)
        viewPager.adapter = PageAdapter(childFragmentManager)
        fav = v.findViewById<View>(R.id.fav) as ImageView
        name = v.findViewById<View>(R.id.name) as TextView

        if(sharedPreferences.getBoolean(viewPager.currentItem.toString(),false)){
            fav.setColorFilter(Color.RED)
        }else{
            fav.setColorFilter(Color.DKGRAY)
        }
        viewPager?.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                if(sharedPreferences.getBoolean(viewPager.currentItem.toString(),false)){
                    fav.setColorFilter(Color.RED)
                }else{
                    fav.setColorFilter(Color.DKGRAY)
                }
            }
        })
        fav.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val editor:SharedPreferences.Editor =  sharedPreferences.edit()
                if(sharedPreferences.getBoolean(viewPager.currentItem.toString(),false)){
                    editor.putBoolean(viewPager.currentItem.toString(),false)
                    fav.setColorFilter(Color.DKGRAY)
                }else{
                    editor.putBoolean(viewPager.currentItem.toString(),true)
                    fav.setColorFilter(Color.RED)

                }
                editor.apply()
            }
        })
        return v
    }
}