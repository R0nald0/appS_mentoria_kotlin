package com.example.quizapp

class DadosPerguntas {

  companion object{
    fun recuperarListaPerguntas():Array<Pergunta>{
      val pergunta2 = Pergunta(
        "Qual foi a durcao do primero video do Youtube?",
        "3 minutos","1 Minuto","18 Segundas",
        3
      )
      val pergunta = Pergunta(
         "Em média quantas pesquisas sao feitas no google",
         "450 milhões","1 Bilhão","280 Milhões",
         1
       )
      val pergunta3 = Pergunta(
        "Primeira rede social?",
        "MySpace","ClassMate","Orkut",
        2
      )
      val pergunta4 = Pergunta(
        "Quantos bits cabem em um Byte?",
        "1 bits","4 bits","8 bits",
        3
      )

      val listaPerguntas = arrayOf(
         pergunta,pergunta2,pergunta3,pergunta4
      )

      return listaPerguntas
    }
  }
}