package com.example.movieaplcation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movieaplcation.api.RetrofitHelper
import com.example.movieaplcation.api.ServiceFilmesApi
import com.example.movieaplcation.databinding.ActivityMainBinding
import com.example.movieaplcation.model.Filme
import com.example.movieaplcation.model.FilmeResposta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private  val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val  api by lazy {
        RetrofitHelper.api
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnExecutar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                recuperarFilmesPopulares()
            }
        }

    }

  private suspend fun recuperarFilmesPopulares() {
         var resposta : Response<FilmeResposta>?=null

         try {
             val serviceFilme = api.create(ServiceFilmesApi::class.java)
              resposta = serviceFilme.getFilmesApi()
          }catch (e :Exception){
             e.printStackTrace()
             Log.i("tag", "recuperarFilmesPopulares: ${e.message} ")
         }

      if (resposta !=null && resposta.isSuccessful){
            val filmeResposta = resposta.body()
           val page = resposta.body()?.page
            val listaFilmes = filmeResposta?.filmes
                listaFilmes?.forEach {
                   val filme = Filme(
                        it.adult,it.backdrop_path,it.genre_ids,
                        it.id,it.release_date,it.title,it.video
                    )


                    Log.i("tag", "Total filmes: ${filme.title} ")

            }
          Log.i("tag", "Total filmes: ${filmeResposta?.total_results} ")
          Log.i("tag", "Total filmes: ${page} ")

      }else{
          Log.i("tag", "Erro: ${resposta?.code()} ")
          Log.i("tag", "Erro: ${resposta?.body()} ")
      }
    }
}