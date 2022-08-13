package com.brilhante.imc_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.brilhante.imc_app.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peso = intent.getStringExtra("EXTRA_PESO")
        val altura = intent.getStringExtra("EXTRA_ALTURA")

        calcularIMC(peso.toString(), altura.toString())

    }



    private fun calcularIMC (peso: String, altura: String ) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            val imcFormated = String.format("%.2f", imc)
            binding.resultTXT.text = "O seu IMC é de: ${imcFormated} Kg/m²"
        }
    }

    }
