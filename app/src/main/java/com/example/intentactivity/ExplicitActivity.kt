package com.example.intentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentactivity.databinding.ActivityExplicitBinding

class ExplicitActivity : AppCompatActivity() {
    lateinit var binding: ActivityExplicitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplicitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExplicit.setOnClickListener {
             if (binding.etString.text.toString().trim().isNullOrEmpty()){
                 binding.etString.error = "Enter string value"
             }else if(binding.etDouble.text.toString().trim().isNullOrEmpty()){
                 binding.etDouble.error = "Enter double value"
             }else if (binding.etFloat.text.toString().trim().isNullOrEmpty()){
                 binding.etFloat.error = "Enter float value"
             }else if (binding.etInteger.text.toString().trim().isNullOrEmpty()){
                 binding.etInteger.error = "Enter integer value"
             }else{
                var intent = Intent(this, ImlicitActivity::class.java)
                 intent.putExtra("string", binding.etString.text.toString())
                 intent.putExtra("double", binding.etDouble.text.toString().toDouble())
                 intent.putExtra("float", binding.etFloat.text.toString().toFloat())
                 intent.putExtra("integer", binding.etInteger.text.toString().toInt())
                 startActivity(intent)
             }

        }
    }
}