package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.GamesDB
import br.senai.sp.jandira.games.model.User

class UserRepository(context: Context) {

    private val db = GamesDB.getDataBase(context).userDao()

    fun save(user: User): Long{
        return db.save(user)
    }

    fun update(user: User): Int{
        return db.update(user)
    }

    fun delete(user: User): Int{
        return db.delete(user)
    }

    fun getAll(): List<User> {
        return db.getAll()
    }

    fun getUserById(id: Int): User {
        return db.getUserById(id)
    }
}