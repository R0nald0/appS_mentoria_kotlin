package com.example.quizapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.ItemRcViewBinding

class UsuarioAdpter(
    var lisUSER : MutableList<Usuario>
) :RecyclerView.Adapter<UsuarioAdpter.UsuarioViewHolder>() {
    var listRankUsuario = lisUSER
    inner class UsuarioViewHolder(item :ItemRcViewBinding) : RecyclerView.ViewHolder(item.root){

           private lateinit var binding: ItemRcViewBinding
        init {
              binding= item
        }

        fun bind(usuario: Usuario){
            binding.nomeUser.text = usuario.nome
            binding.pontuacaoUser.text = usuario.qtdAcertos.toString()

            itemView.setOnClickListener {
               val usua = Usuario("tess",4)
                Toast.makeText(itemView.context, "CLICADO", Toast.LENGTH_LONG).show()
                listRankUsuario.add(usua);
                notifyDataSetChanged()
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {

        val itemBindinUser = ItemRcViewBinding
            .inflate(LayoutInflater.from(parent.context))
        return UsuarioViewHolder(itemBindinUser)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {

          var usuario = listRankUsuario[position]

          holder.bind(usuario)


    }

    override fun getItemCount(): Int {
        return  listRankUsuario.size
    }

    fun addUsuario(usuario: Usuario){
         listRankUsuario.add(usuario);
         notifyDataSetChanged()
    }
}