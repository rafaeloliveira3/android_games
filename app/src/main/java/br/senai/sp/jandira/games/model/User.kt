package br.senai.sp.jandira.games.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
class User {
    @PrimaryKey(autoGenerate = true)
    var id = 0

//    var foto: Bitmap? = null
    var email = ""
    var senha = ""
    var nome = ""
    var cidade = ""
    var gender = 'I'

    @ColumnInfo(name = "data-nascimento")
    var dataNascimento: String? = null

    var nivel = Nivel.INICIANTE
//    var console: Console? = null
}