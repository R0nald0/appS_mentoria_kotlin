package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.*
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityPerguntasBinding
import kotlin.math.log

class PerguntasActivity : AppCompatActivity() {

    lateinit var txvNome :TextView
    lateinit var txvNumeroPergunta:TextView
    lateinit var txvPerguntas:TextView
    lateinit var  radioGroup: RadioGroup
    lateinit var  radioButton1: RadioButton
    lateinit var  radioButton2: RadioButton
    lateinit var  radioButton3: RadioButton
    lateinit var  btnConfirmarResposta : Button
    lateinit var listaPergunta : Array<Pergunta>
    private  var indicePergunta = 0
    private  var totalAcertos = 0

    private lateinit var binding: ActivityPerguntasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerguntasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getViews()
    }

    fun recuperarDados(){
        val bundle = intent.extras
        val usuario =bundle?.getParcelable<Usuario>("usuario")

        if (usuario != null) {
            exibirCampos(usuario)
            mostrarPergunta()
            btnConfirmarResposta.setOnClickListener {

                if (validarResposta()){
                    val tamnhoLista = listaPergunta.size

                    recuperaRespostaSelecionada(usuario)

                    indicePergunta++
                    if (indicePergunta < tamnhoLista){
                        mostrarPergunta()
                        txvNumeroPergunta.text ="${indicePergunta + 1}  de  ${tamnhoLista} Perguntas "

                    }else{
                        val intent = Intent(this,ResultadoActivity::class.java)
                        intent.putExtra("usuario",usuario)
                        startActivity(intent)
                        finish()
                    }

                }else{
                    Toast.makeText(this,"Escolha uma Opção",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun recuperaRespostaSelecionada(usuario: Usuario){
         val  indiceResposta= when{
             radioButton1.isChecked -> 1
             radioButton2.isChecked -> 2
             radioButton3.isChecked -> 3
            else -> -1
         }

        val pergunta = listaPergunta [indicePergunta]

        if (indiceResposta == pergunta.resposta){
            Toast.makeText(this,"Acertou",Toast.LENGTH_LONG).show()
            totalAcertos += 1
            usuario.qtdAcertos =totalAcertos
            exibirCampos(usuario)
        }else{
            Toast.makeText(this,"Errou",Toast.LENGTH_LONG).show()
        }
    }
    fun validarResposta(): Boolean{
        return (radioButton1.isChecked || radioButton2.isChecked || radioButton3.isChecked )
    }

    private fun mostrarPergunta() {
       listaPergunta = DadosPerguntas.recuperarListaPerguntas()

        val pergunta = listaPergunta[indicePergunta]
        txvPerguntas.text = pergunta.titulo
        radioButton1.text = pergunta.respostas01
        radioButton2.text = pergunta.respostas02
        radioButton3.text = pergunta.respostas03

        radioGroup.clearCheck();
    }

    fun exibirCampos(usuario: Usuario){
         txvNome.text = "ola,${usuario.nome} Acertos : ${usuario.qtdAcertos}";
    }

    fun getViews(){
        with(binding){
            txvNome = idTxvNomeUser
            txvNumeroPergunta = idTxvNumeroPerguntas
            txvPerguntas = idPerguntas
            radioGroup =idRadioGroup
            radioButton1 = idRadioBtn1
            radioButton2 = idRadioBtn2
            radioButton3 = idRadioBtn3
            btnConfirmarResposta = idBtnConfirmarResp
        }
        recuperarDados()
    }
}