package com.example.rr.fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rr.CustomAdapter
import com.example.rr.ItemsViewModel
import com.example.rr.R

class fav : Fragment() {

    private val sharedPrefFile = "user"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.fragment_fav, container, false)

        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        val recyclerview = v.findViewById<RecyclerView>(R.id.item)
        recyclerview.layoutManager = LinearLayoutManager(context)
        val data = ArrayList<ItemsViewModel>()
        if(sharedPreferences.getBoolean("0",false)){
            data.add(ItemsViewModel(R.drawable.spaghettis, "Spaghetti"))
        }else{
            data.remove(ItemsViewModel(R.drawable.spaghettis, "Spaghetti"))
        }
        if(sharedPreferences.getBoolean("1",false)){
            data.add(ItemsViewModel(R.drawable.salad, "Salat"))
        }else{
            data.remove(ItemsViewModel(R.drawable.salad, "Salat"))
        }
        if(sharedPreferences.getBoolean("2",false)){
            data.add(ItemsViewModel(R.drawable.pizza, "Pizza"))
        }else{
            data.remove(ItemsViewModel(R.drawable.pizza, "Pizza"))
        }
        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

        return v
    }

}