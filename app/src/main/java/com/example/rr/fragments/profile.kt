package com.example.rr.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.rr.MainActivity
import com.example.rr.R

class profile : Fragment() {

    private val sharedPrefFile = "user"
    private lateinit var name: TextView
    private lateinit var name1: TextView
    private lateinit var email: TextView
    private lateinit var pass: TextView
    private lateinit var logout: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v: View = inflater.inflate(R.layout.fragment_profile, container, false)
        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        name = v.findViewById<View>(R.id.name) as TextView
        name.setText(sharedPreferences.getString("name",""))
        name1 = v.findViewById<View>(R.id.name1) as TextView
        name1.setText(sharedPreferences.getString("name",""))
        email = v.findViewById<View>(R.id.email) as TextView
        email.setText(sharedPreferences.getString("email",""))
        pass = v.findViewById<View>(R.id.pass) as TextView
        pass.setText(sharedPreferences.getString("pass",""))



        logout = v.findViewById<View>(R.id.logout) as ImageButton

        logout.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val editor:SharedPreferences.Editor =  sharedPreferences.edit()
                editor.putBoolean("is",false)
                editor.putString("email", " ")
                editor.apply()
                val i = Intent(activity, MainActivity::class.java)
                startActivity(i)
                requireActivity().finish()
            }
        })
        return v
    }
}