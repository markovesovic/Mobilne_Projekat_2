package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_stats.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.UserContract
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.activities.LogInActivity
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.UserViewModel

class StatsFragment : Fragment(R.layout.fragment_stats) {

    private val userViewModel: UserContract.ViewModel by sharedViewModel<UserViewModel>()
    private val sharedPreferences: SharedPreferences by inject<SharedPreferences>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        userInfo.setOnClickListener {

            val username = sharedPreferences.getString("username", "") ?: ""
            val password = sharedPreferences.getString("password", "") ?: ""

            Toast.makeText(this.context, "Name $username, Pin $password", Toast.LENGTH_SHORT).show()
        }
        logOut.setOnClickListener {
            sharedPreferences.edit().putBoolean("isLoggedIn", false).commit()
            val intent = Intent(this.context, LogInActivity::class.java)
            startActivity(intent)
            this.activity?.finish()
        }
    }

}