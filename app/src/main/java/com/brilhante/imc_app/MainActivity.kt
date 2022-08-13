package com.brilhante.imc_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brilhante.imc_app.databinding.ActivityMainBinding

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


