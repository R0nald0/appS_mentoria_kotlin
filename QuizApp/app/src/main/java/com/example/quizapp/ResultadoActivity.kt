package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.ActivityPerguntasBinding
import com.example.quizapp.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultadoBinding
      var listUser = mutableListOf<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras =intent.extras
        val usuario = extras?.getParcelable<Usuario>("usuario")
        if (usuario != null) {
            listUser.add(usuario)
            binding.idResultado.text = "Acertos ${usuario.qtdAcertos}"
            binding.nomUser.text = usuario.nome.uppercase()

            binding.rcView.adapter = UsuarioAdpter(listUser)
            binding.rcView.layoutManager = LinearLayoutManager(this)
            binding.rcView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
            binding.btnRecomecar.setOnClickListener {

            }

            binding.btnNovoQuiz.setOnClickListener {
                  val intent = Intent(this,MainActivity::class.java)
                  startActivity(intent)
            }
        }

    }

    override fun onDestroy() {
        Toast.makeText(this, "DESTRUIDA", Toast.LENGTH_LONG).show()
        super.onDestroy()
    }
}