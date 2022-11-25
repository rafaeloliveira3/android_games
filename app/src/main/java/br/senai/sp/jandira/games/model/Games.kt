package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_games")
class Games {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    var desenvolvedora = ""
    var nome = ""
    var descricao = ""
//    var imagem: Bitmap? = null
    var finalizado = false

}