package com.example.rr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.rr.fragments.fav
import com.example.rr.fragments.hot
import com.example.rr.fragments.profile
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {


    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadFragment(hot())
        bottomNav = findViewById(R.id.bottomnav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.love -> {
                    loadFragment(fav())
                }
                R.id.hot -> {
                    loadFragment(hot())
                }
                R.id.profile -> {
                    loadFragment(profile())
                }
            }
            true
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flFragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
