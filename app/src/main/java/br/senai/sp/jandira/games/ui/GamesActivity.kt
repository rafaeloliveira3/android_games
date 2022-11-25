package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.databinding.ActivityGamesBinding
import br.senai.sp.jandira.games.repository.UserRepository

class GamesActivity : AppCompatActivity() {

    lateinit var rvGames: RecyclerView
    lateinit var adapterGames: GamesAdapter
    lateinit var binding: ActivityGamesBinding
    lateinit var userRepo: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepo = UserRepository(this)

        val id = intent.getIntExtra("id", 0)
        val user = userRepo.getUserById(id)

        rvGames = findViewById(R.id.rv_games)

        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterGames = GamesAdapter(this)

        rvGames.adapter = adapterGames

        binding.userName.text = user.nome
        binding.userEmail.text = user.email
        binding.gamerLevel.text = user.nivel.toString()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflator = menuInflater
        inflator.inflate(R.menu.menu_games, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add -> {
                Toast.makeText(this, "new", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                val data = getSharedPreferences("data", MODE_PRIVATE)
                val editor = data.edit()
                editor.remove("id")
                editor.commit()

                val abrirMainActivity = Intent(this, MainActivity::class.java)
                startActivity(abrirMainActivity)
                true
            }
        }
    }
}