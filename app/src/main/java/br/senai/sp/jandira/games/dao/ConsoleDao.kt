package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.Console

@Dao
interface ConsoleDao {
    @Insert
    fun save(console: Console): Long

    @Delete
    fun delete(console: Console): Int

    @Update
    fun update(console: Console): Int

    @Query("SELECT * FROM tbl_console ORDER by id ASC")
    fun getAll(): List<Console>

    @Query("SELECT * FROM tbl_console where id = :id")
    fun getUserById(id: Int): Console
}