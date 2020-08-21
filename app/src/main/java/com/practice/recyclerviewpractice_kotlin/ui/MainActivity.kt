package com.practice.recyclerviewpractice_kotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.recyclerviewpractice_kotlin.R
import com.practice.recyclerviewpractice_kotlin.data.Cars
import com.practice.recyclerviewpractice_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnCardItemClickListner {
    lateinit var binding: ActivityMainBinding
    lateinit var carslist: ArrayList<Cars>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        carslist = ArrayList()
        createCarsList();
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this,1))
        binding.recyclerView.adapter = CarAdapter(carslist, this)
    }

    fun createCarsList(){
        carslist.add(Cars("A", "Acura"))
        carslist.add(Cars("B", "BMW"))
        carslist.add(Cars("C", "Chevrolet"))
        carslist.add(Cars("D", "Dodge"))
        carslist.add(Cars("F", "Ford"))
        carslist.add(Cars("G", "GMC"))
        carslist.add(Cars("H", "Honda"))
        carslist.add(Cars("I", "Infiniti"))
        carslist.add(Cars("j", "Jaguar"))
        carslist.add(Cars("K", "Kia"))
        carslist.add(Cars("L", "Land Rover"))
        carslist.add(Cars("M", "Mazda"))
        carslist.add(Cars("N", "Nissan"))
    }

    override fun onItemClick(item: Cars, position: Int) {
        val intent =  Intent(this, DetailsActivity::class.java)
        intent.putExtra("CAR",item.description.toString());
        startActivity(intent)
    }
}