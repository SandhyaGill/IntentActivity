package com.example.intentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnImplicit.setOnClickListener {
            var intent = Intent(this, ImlicitActivity::class.java)
            startActivity(intent)
        }
        binding.btnExplicit.setOnClickListener {
            var intent = Intent(this, ExplicitActivity::class.java)
            startActivity(intent)
        }
    }
}