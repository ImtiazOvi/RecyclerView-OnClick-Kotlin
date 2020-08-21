package com.practice.recyclerviewpractice_kotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.practice.recyclerviewpractice_kotlin.R
import com.practice.recyclerviewpractice_kotlin.databinding.ActivityDetailsBinding


class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.txtPosition.text = getIntent().getStringExtra("CAR")
    }
}