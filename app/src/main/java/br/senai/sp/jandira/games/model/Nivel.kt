package br.senai.sp.jandira.games.model

import br.senai.sp.jandira.games.R

enum class Nivel(val level: String){
    INICIANTE("${R.string.beginner}"),
    BASICO("${R.string.basic}"),
    AVANCADO("${R.string.advanced}"),
    CASUAL("${R.string.casual}")
}