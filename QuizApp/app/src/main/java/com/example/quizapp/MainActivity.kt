package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


  private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idBtnIniciar.setOnClickListener {
            verificarCampos()
        }
    }

    private  fun verificarCampos():Boolean{
        if(binding.idEdtMeuNome.text.toString().isNotEmpty()){
            val intent = Intent(this,PerguntasActivity::class.java)
            val usuario = Usuario(binding.idEdtMeuNome.text.toString(),0)
            intent.putExtra("usuario",usuario )
            startActivity(intent)
            finish()
            return true
        }
       Toast.makeText(this,"Preencha seu nome....",Toast.LENGTH_LONG).show()
        return false
    }

}
