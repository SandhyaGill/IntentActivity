package com.example.intentactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intentactivity.databinding.ActivityImlicitBinding

class ImlicitActivity : AppCompatActivity() {
    lateinit var binding : ActivityImlicitBinding
    var tvString :String? = ""
    var tvDouble :Double = 0.0
    var tvFloat :Float = 0.0f
    var tvInteger :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImlicitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent = getIntent()
        tvString = intent.getStringExtra("string")
        tvDouble = intent.getDoubleExtra("double",0.0)
        tvFloat = intent.getFloatExtra("float",0.0f)
        tvInteger = intent.getIntExtra("integer",0)
//        println("string $tvString, double $tvDouble, float $tvFloat, integer $tvInteger")

        binding.tvString.setText("String: $tvString")
        binding.tvDouble.setText("Double: $tvDouble")
        binding.tvFloat.setText("Float: $tvFloat")
        binding.tvInteger.setText("Integer: $tvInteger")


        binding.tvDialNumber.setOnClickListener {
            try {
                var intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("1234567886"))
                startActivity(intent)
            }catch (exception : Exception){
                Toast.makeText(this, "Can't call on this number", Toast.LENGTH_SHORT).show()
            }

        }
        binding.tvOpenWebsite.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com/"))
            startActivity(intent)
        }
        binding.tvSendSMS.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("sms:"))
            intent.setType("vnd.android-dir/mms-sms")
            startActivity(intent)
        }
        binding.tvSendEmail.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.setData(Uri.parse("text/html"))
            intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "This is subject")
            intent.putExtra(Intent.EXTRA_TEXT,"This is text")
            startActivity(Intent.createChooser(intent,"send Email"))
        }
    }
}
