package com.example.quizapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario (
    var nome:String,
    var qtdAcertos :Int,
): Parcelable
