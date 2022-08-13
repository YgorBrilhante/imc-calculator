package com.brilhante.imc_app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.brilhante.imc_app.databinding.ActivityMainBinding
import android.content.Intent as Intent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcularBTN.setOnClickListener {
            val intent = Intent(applicationContext, ResultActivity::class.java);
            intent.putExtra("EXTRA_ALTURA", binding.alturaEDT.getText().toString())
            intent.putExtra("EXTRA_PESO", binding.pesoEDT.getText().toString())
            startActivity(intent)
        };



    }

}


