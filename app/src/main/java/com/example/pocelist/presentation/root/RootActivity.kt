package com.example.pocelist.presentation.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pocelist.databinding.ActivityRootBinding

class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRootBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}