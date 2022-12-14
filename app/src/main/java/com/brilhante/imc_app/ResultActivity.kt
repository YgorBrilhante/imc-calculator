package com.brilhante.imc_app

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
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

            if(imc.toDouble() < 18.50){
               binding.classificationTXT.text = "Classificação: Abaixo do peso"
            } else if (imc.toDouble() >= 18.50 && imc.toDouble() < 24.90){
                binding.classificationTXT.text = "Classificação: Peso Normal"
            } else if (imc.toDouble() >= 24.90 && imc.toDouble() < 29.90) {
                binding.classificationTXT.text = "Classificação: Sobrepeso"
            } else if (imc.toDouble() >= 29.90) {
                binding.classificationTXT.text = "Classificação: Obesidade"
            }
        }
    }

    }
