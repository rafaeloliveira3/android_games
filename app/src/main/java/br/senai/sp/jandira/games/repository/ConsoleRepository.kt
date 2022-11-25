//package br.senai.sp.jandira.games.repository
//
//import android.content.Context
//import br.senai.sp.jandira.games.dao.GamesDB
//import br.senai.sp.jandira.games.model.Console
//
//class ConsoleRepository(context: Context) {
//    private val db = GamesDB.getDataBase(context).consoleDao()
//
//    fun save(console: Console): Long{
//        return db.save(console)
//    }
//
//    fun update(console: Console): Int{
//        return db.update(console)
//    }
//
//    fun delete(console: Console): Int{
//        return db.delete(console)
//    }
//
//    fun getAll(): List<Console> {
//        return db.getAll()
//    }
//
//    fun getUserById(id: Int): Console {
//        return db.getUserById(id)
//    }
//}