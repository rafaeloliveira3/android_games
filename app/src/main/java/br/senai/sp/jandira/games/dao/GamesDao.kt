package br.senai.sp.jandira.games.dao

import android.content.Context
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Games

class GamesDao {
    companion object {
        fun getGames(context: Context): List<Games> {

            val game1 = Games()
            game1.id = 1
            game1.nome = "Street Fighter"
            game1.descricao = "Street Fighter, popularly abbreviated to SF, is a popular fighting game series."
            game1.desenvolvedora = "Capcom"
            game1.imagem = context.getDrawable(R.drawable.street_fighter)

            val game2 = Games()
            game2.id = 2
            game2.nome = "Ninja Turtles II"
            game2.descricao = "Teenage Mutant Ninja Turtles: Shredder's Revenge is a beat 'em up video game developed by Tribute Games."
            game2.desenvolvedora = "Konami"
            game2.imagem = context.getDrawable(R.drawable.turtles)

            val game3 = Games()
            game3.id = 2
            game3.nome = "Garry's Mod"
            game3.descricao = "Garry's Mod is a sandbox game created in 2004 by Garry Newman."
            game3.desenvolvedora = "Facepunch Studios Ltd"
            game3.imagem = context.getDrawable(R.drawable.gmod)

            return listOf(game1, game2, game3)
        }
    }
}