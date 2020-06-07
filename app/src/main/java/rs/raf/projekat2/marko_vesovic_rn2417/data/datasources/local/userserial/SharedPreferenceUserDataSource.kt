package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.userserial

import android.content.SharedPreferences
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.UserData

class SharedPreferenceUserDataSource(
    private val sharedPreferences: SharedPreferences
): UserDataSource {

    companion object {
        const val USER_NAME_KEY = "userName"
        const val PASSWORD_KEY = "password"
        const val USER_INFO_KEY = "userInfo"
        const val IS_LOGGED_IN = "isUserLoggedIn"
    }

    private val editor = sharedPreferences.edit()

    override fun setUserData(uD: UserData) {
        editor.putString(USER_NAME_KEY, uD.username)
        editor.putString(PASSWORD_KEY, uD.password)
        editor.putString(USER_INFO_KEY, uD.info)
        editor.commit()
    }

    override fun getUserData(): UserData {
        return UserData(
            sharedPreferences.getString(USER_NAME_KEY, "") ?: "",
            sharedPreferences.getString(PASSWORD_KEY, "") ?: "",
            sharedPreferences.getString(USER_INFO_KEY, "" ) ?: ""
        )
    }

    override fun setLoggedIn(li: Boolean) {
        editor.putBoolean(IS_LOGGED_IN, li)
        editor.commit()
    }

    override fun getLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false)
    }
}