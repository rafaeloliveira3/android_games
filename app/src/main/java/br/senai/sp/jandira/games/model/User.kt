package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

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

//    @ColumnInfo(name = "data-nascimento")
//    var dataNascimento: LocalDate? = null

    var nivel = Nivel.INICIANTE
//    var console: Console? = null
}