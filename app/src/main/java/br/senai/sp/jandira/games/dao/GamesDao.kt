package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.Games

@Dao
interface GamesDao {
    @Insert
    fun save(games: Games): Long

    @Delete
    fun delete(games: Games): Int

    @Update
    fun update(games: Games): Int

    @Query("SELECT * FROM tbl_games ORDER by id ASC")
    fun getAll(): List<Games>

    @Query("SELECT * FROM tbl_games where id = :id")
    fun getUserById(id: Int): Games
}