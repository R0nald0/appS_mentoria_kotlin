package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)
        getViews()
    }

    fun recuperarDados(){
        val bundle = intent.extras
        val nome =bundle?.getString("nome")?:"Usuario"

        exibirCampos(nome)
        mostrarPergunta()

        btnConfirmarResposta.setOnClickListener {

           if (validarResposta()){
               val tamnhoLista = listaPergunta.size
               recuperaRespostaSelecionada()

               indicePergunta++
               if (indicePergunta < tamnhoLista){
                   mostrarPergunta()
                   txvNumeroPergunta.text ="${indicePergunta + 1}  de  ${tamnhoLista} Perguntas "

               }else{
                    var intent = Intent(this,ResultadoActivity::class.java)
                    intent.putExtra("acertos",totalAcertos)
                     startActivity(intent)
               }

           }else{
               Toast.makeText(this,"Escolha uma Opção",Toast.LENGTH_LONG).show()
           }

        }
    }

    fun recuperaRespostaSelecionada(){
         val  indiceResposta= when{
             radioButton1.isChecked -> 1
             radioButton2.isChecked -> 2
             radioButton3.isChecked -> 3
            else -> -1
         }

        val  pergunta = listaPergunta [indicePergunta]

        if (indiceResposta == pergunta.resposta){
            Toast.makeText(this,"Acertou",Toast.LENGTH_LONG).show()
            totalAcertos += 1
        }else{
            Toast.makeText(this,"Errou",Toast.LENGTH_LONG).show()
        }
    }


    fun validarResposta(): Boolean{
        return (radioButton1.isChecked || radioButton2.isChecked || radioButton3.isChecked )


    }

    private fun mostrarPergunta() {
       listaPergunta = DadosPerguntas.recuperarListaPerguntas()
        Log.i("listaperguntas", listaPergunta.toString())

        /*
        for(pergunta in listaPergunta){
            Log.i("listaperguntas" , pergunta.titulo)
            Log.i("listaperguntas" , pergunta.titulo)
        }
         */

        val pergunta01 = listaPergunta[indicePergunta]
        txvPerguntas.text = pergunta01.titulo
        radioButton1.text = pergunta01.respostas01
        radioButton2.text = pergunta01.respostas02
        radioButton3.text = pergunta01.respostas03

        radioGroup.clearCheck();


    }

    fun exibirCampos(nome:String){
         txvNome.text = "ola,${nome}";
    }

    fun getViews(){
        txvNome = findViewById(R.id.idTxvNomeUser)
        txvNumeroPergunta = findViewById(R.id.idTxvNumeroPerguntas)
        txvPerguntas = findViewById(R.id.idPerguntas)
        radioGroup = findViewById(R.id.idRadioGroup)
        radioButton1 = findViewById(R.id.idRadioBtn1)
        radioButton2 = findViewById(R.id.idRadioBtn2)
        radioButton3 = findViewById(R.id.idRadioBtn3)
        btnConfirmarResposta = findViewById(R.id.idBtnConfirmarResp)

        recuperarDados()
    }
}