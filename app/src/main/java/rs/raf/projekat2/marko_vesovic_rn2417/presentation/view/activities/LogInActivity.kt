package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_log_in.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.UserContract
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.UserViewModel

class LogInActivity : AppCompatActivity(R.layout.activity_log_in) {

    private val userViewModel: UserContract.ViewModel by viewModel<UserViewModel>()
    private val sharedPreferences: SharedPreferences by inject<SharedPreferences>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        logInButton.setOnClickListener {
            if(usernameEditText.text.toString() != "" && pinEditText.text.toString() != "") {
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.putString("username", usernameEditText.text.toString())
                editor.putString("password", pinEditText.text.toString())
                editor.commit()
//               userViewModel.setLoggedIn(true)
//               userViewModel.setUser(user)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }


        }
    }

}