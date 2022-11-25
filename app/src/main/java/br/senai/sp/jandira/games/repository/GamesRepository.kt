//package br.senai.sp.jandira.games.repository
//
//import android.content.Context
//import br.senai.sp.jandira.games.dao.GamesDB
//import br.senai.sp.jandira.games.model.Games
//
//class GamesRepository(context: Context) {
//    private val db = GamesDB.getDataBase(context).gamesDao()
//
//    fun save(games: Games): Long{
//        return db.save(games)
//    }
//
//    fun update(games: Games): Int{
//        return db.update(games)
//    }
//
//    fun delete(games: Games): Int{
//        return db.delete(games)
//    }
//
//    fun getAll(): List<Games> {
//        return db.getAll()
//    }
//
//    fun getUserById(id: Int): Games {
//        return db.getUserById(id)
//    }
//}