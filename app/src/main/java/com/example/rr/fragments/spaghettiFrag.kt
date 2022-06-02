package com.example.rr.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import com.example.rr.R
import java.util.*

class spaghettiFrag : Fragment() {

    private lateinit var flayout:FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.fragment_spaghetti, container, false)

        flayout = v.findViewById<View>(R.id.spag) as FrameLayout
        flayout.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


            }
        })

        return v
    }
}