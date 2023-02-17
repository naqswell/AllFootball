package com.naqswell.allfootball.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naqswell.allfootball.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}




