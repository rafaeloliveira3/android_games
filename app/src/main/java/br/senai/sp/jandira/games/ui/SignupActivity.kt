package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivitySignupBinding
import br.senai.sp.jandira.games.model.Nivel
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.UserRepository

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var user: User
    private lateinit var userRepo: UserRepository
    private lateinit var level: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gamerLevel = Nivel.values().map(Enum<*>::name)
        level = gamerLevel[0]

        binding.gamerLevelText.text = level
        user = User()
        
        binding.gamerlevelSlider.addOnChangeListener { _, value, _ ->
            level = gamerLevel[value.toInt() - 1]
            binding.gamerLevelText.text = level
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_signup, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_save -> {
                save()
                true
            }
            else -> {
                val abrirMainActivity = Intent(this, MainActivity::class.java)
                startActivity(abrirMainActivity)
                true
            }
        }
    }

    private fun save() {
        if (validar()) {
            user.email = binding.editEmail.text.toString()
            user.senha = binding.editPassword.text.toString()
            user.nome = binding.editName.text.toString()
            user.cidade = binding.editCity.text.toString()

            var id = binding.radioGender.checkedRadioButtonId
            user.gender = this.findViewById<RadioButton>(id).text.first()

            user.nivel = Nivel.valueOf(level)

            userRepo = UserRepository(this)
            userRepo.save(user)

            finish()
        }
    }

    private fun validar(): Boolean {
        if (binding.editEmail.text.isEmpty()) {
            binding.editEmail.error = "${this.getString(R.string.field_required)}"
            return false
        }
        else if(binding.editPassword.text.isEmpty()) {
            binding.editPassword.error = "${this.getString(R.string.field_required)}"
            return false
        }
        else if(binding.editName.text.isEmpty()) {
            binding.editName.error = "${this.getString(R.string.field_required)}"
            return false
        }
        else if(binding.editCity.text.isEmpty()) {
            binding.editCity.error = "${this.getString(R.string.field_required)}"
            return false
        }
        else return true
    }
}