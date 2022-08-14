package com.example.receitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rcView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcView =findViewById(R.id.idRcView)

        rcView.adapter = ReceitaAdapter()
        rcView.layoutManager =LinearLayoutManager(this)

    }
}