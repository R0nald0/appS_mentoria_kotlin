package com.example.movieaplcation.model

data class FilmeResposta(
    val page: Int,
    val filmes: List<Filme>,
    val total_pages: Int,
    val total_results: Int
)