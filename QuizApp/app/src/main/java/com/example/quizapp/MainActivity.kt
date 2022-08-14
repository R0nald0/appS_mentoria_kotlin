package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

  private  lateinit var edtMeuNome: EditText
  private  lateinit var btnIniciar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarViews()

        btnIniciar.setOnClickListener {
            verificarCampos()
        }
    }

    private  fun verificarCampos():Boolean{
        if(edtMeuNome.text.toString().isNotEmpty()){
            val intent = Intent(this,PerguntasActivity::class.java)
            intent.putExtra("nome", edtMeuNome.text.toString())
            startActivity(intent)
            finish()
            return true
        }
       Toast.makeText(this,"Preencha seu nome",Toast.LENGTH_LONG).show()
        return false
    }
    private fun iniciarViews(){
        edtMeuNome = findViewById(R.id.idEdtMeuNome)
        btnIniciar = findViewById(R.id.idBtnIniciar)
    }
}