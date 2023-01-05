package com.davidson.compass

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.davidson.compass.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.isDark.observe(this){
            if (it == true) {
                binding.tvStatus.text = "It is Dark"
                binding.tvStatus.setTextColor(Color.parseColor("#000000"))
                binding.homeLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
            } else {
                binding.tvStatus.text = "It is Not Dark"
                binding.tvStatus.setTextColor(Color.parseColor("#FFFFFF"))
                binding.homeLayout.setBackgroundColor(Color.parseColor("#000000"))
            }
        }
    }

}