package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Games

class GamesAdapter(val context: Context) : RecyclerView.Adapter<GamesAdapter.HolderGames>() {

    private var gamesList = listOf<Games>()

    fun updateGamesList(games: List<Games>) {
        this.gamesList = games
        notifyDataSetChanged()
    }

    class HolderGames(view: View) : RecyclerView.ViewHolder(view) {

        val creatorName = view.findViewById<TextView>(R.id.text_creator_name)
        val gameName = view.findViewById<TextView>(R.id.text_game_name)
        val gameDesc = view.findViewById<TextView>(R.id.text_game_desc)
        val gameImage = view.findViewById<ImageView>(R.id.image_holder)

        fun bind(games: Games) {
            creatorName.text = games.desenvolvedora
            gameName.text = games.nome
            gameDesc.text = games.descricao
            gameImage.setImageDrawable(games.imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGames {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)

        return HolderGames(view)
    }

    override fun onBindViewHolder(holder: HolderGames, position: Int) {
        holder.bind(gamesList.get(position))
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

}