package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Games
import br.senai.sp.jandira.games.model.User

@Database(entities = [User::class, Console::class, Games::class], version = 1)
abstract class GamesDB: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private lateinit var instance: GamesDB

        fun getDataBase(context: Context): GamesDB {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(context, GamesDB::class.java, "db_games").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}