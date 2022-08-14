package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    lateinit var resultadoTxv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        resultadoTxv = findViewById(R.id.idResultado)

        val extras =intent.extras
        val acertos = extras?.getInt("acertos")?:null

        resultadoTxv.text = "Acertos $acertos"

    }
}