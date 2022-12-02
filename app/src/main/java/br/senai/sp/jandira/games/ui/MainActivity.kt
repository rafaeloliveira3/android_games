package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.repository.UserRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userRepo: UserRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val data = getSharedPreferences("data", MODE_PRIVATE)
        userRepo = UserRepository(this)

        if (data.getInt("id", 0) != 0) {
            val abrirGamesActivity = Intent(this, GamesActivity::class.java)
            abrirGamesActivity.putExtra("id", data.getInt("id", 0))
            startActivity(abrirGamesActivity)
        }

        binding.textSignup.setOnClickListener {
            val abrirSignupActivity = Intent(this, SignupActivity::class.java)
            startActivity(abrirSignupActivity)
        }

        binding.loginButton.setOnClickListener {
            if (validar()) {
                var token = false
                val email = binding.loginEmail.text.toString()
                val password = binding.loginPassword.text.toString()
                var id = 0
                val editor = data.edit()

                for (user in userRepo.getAll()) {
                    if (email == user.email && password == user.senha) {
                        token = true
                        id = user.id
                        break
                    }
                }

                if (token) {
                    if (binding.rememberMe.isChecked) {
                        editor.putInt("id", id)
                        editor.commit()
                    }
                    val abrirGamesActivity = Intent(this, GamesActivity::class.java)
                    abrirGamesActivity.putExtra("id", id)
                    startActivity(abrirGamesActivity)
                } else {
                    Toast.makeText(
                        this,
                        this.getString(R.string.login_failed),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun validar(): Boolean {
        if (binding.loginEmail.text.isEmpty()) {
            binding.loginEmail.error = this.getString(R.string.field_required)
            return false
        }
        else if(binding.loginPassword.text.isEmpty()) {
            binding.loginPassword.error = this.getString(R.string.field_required)
            return false
        }
        else return true
    }
}