package com.example.receitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetalhesActivity : AppCompatActivity() {

    private lateinit var txvTituloDetalhes :TextView
    private lateinit var  imgDetalhes : ImageView
    private lateinit var  txvTempoDetalhe :TextView
    private lateinit var  txvReceitaLis :TextView
    private lateinit var  btnVoltar :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        txvTituloDetalhes =findViewById(R.id.id_txv_tituloReceitaDetalhes)
        txvTempoDetalhe =findViewById(R.id.id_txv_tempoReceitaDetalhes)
        txvReceitaLis =findViewById(R.id.id_txv_ingredientesReceitaDetalhes)
        imgDetalhes = findViewById(R.id.id_imgReceitaDetalhes)
        btnVoltar =findViewById(R.id.id_BtnVoltarDetalhes)


        btnVoltar.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }


        val  extras = intent.extras
         val receita  = extras?.getParcelable<Receita>("receita")!!

        Toast.makeText(this, receita.titulo, Toast.LENGTH_SHORT).show()
        imgDetalhes.setImageDrawable(getDrawable(receita.Imagem))
        txvTituloDetalhes.text= receita.titulo.uppercase()
        txvTempoDetalhe.text = receita.tempo
        var ingrediente =""
        receita.ingredientes.map {
             ingrediente += "- $it \n"
            txvReceitaLis.text = ingrediente
        }




    }
}