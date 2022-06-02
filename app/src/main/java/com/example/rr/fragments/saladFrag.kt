package com.example.rr.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.rr.R

class saladFrag : Fragment() {

    private lateinit var flayout: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v: View = inflater.inflate(R.layout.fragment_salad, container, false)


        flayout = v.findViewById<View>(R.id.salat) as FrameLayout
        flayout.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

            }
        })

        return v
    }

}