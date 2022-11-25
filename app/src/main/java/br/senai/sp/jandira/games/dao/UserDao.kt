package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.User

@Dao
interface UserDao {
    @Insert
    fun save(user: User): Long

    @Delete
    fun delete(user: User): Int

    @Update
    fun update(user: User): Int

    @Query("SELECT * FROM tbl_user ORDER by id ASC")
    fun getAll(): List<User>

    @Query("SELECT * FROM tbl_user where id = :id")
    fun getUserById(id: Int): User
}