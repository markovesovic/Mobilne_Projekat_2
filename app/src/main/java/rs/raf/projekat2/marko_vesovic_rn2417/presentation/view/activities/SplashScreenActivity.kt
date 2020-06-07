package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.UserContract
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.UserViewModel

class SplashScreenActivity : AppCompatActivity() {

    private val userViewModel: UserContract.ViewModel by viewModel<UserViewModel>()
    private val sharedPreferences: SharedPreferences by inject<SharedPreferences>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val loggedIn = userViewModel.isLoggedIn.value

        val loggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        val intent = if (loggedIn) {
            Intent(this, MainActivity::class.java)
        } else {
            Intent(this, LogInActivity::class.java)
        }

        startActivity(intent)
        finish()
    }

}