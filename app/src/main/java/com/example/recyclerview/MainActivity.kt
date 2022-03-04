package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter({toastText()},this, getItemsList())
        binding.recyclerView.adapter = adapter
    }


    private fun getItemsList(): List<ImageDataClass> {
        val list = listOf<ImageDataClass>(
             ImageDataClass(R.mipmap.supra,"Supra",RecyclerViewAdapter.VIEW_TYPE_ONE),
             ImageDataClass(R.mipmap.eleanor,"Eleanor",RecyclerViewAdapter.VIEW_TYPE_TWO),
             ImageDataClass(R.mipmap.gtr,"GTR",RecyclerViewAdapter.VIEW_TYPE_ONE),
             ImageDataClass(R.mipmap.shelby_cobra,"Shelby_cobra",RecyclerViewAdapter.VIEW_TYPE_TWO),
             ImageDataClass(R.mipmap.silvia,"Silvia",RecyclerViewAdapter.VIEW_TYPE_ONE),
        )
        return list
    }

    fun toastText(){
        Toast.makeText(this, "I Love It", Toast.LENGTH_SHORT).show()
    }



}
