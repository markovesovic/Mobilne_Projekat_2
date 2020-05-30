package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.user

import android.content.SharedPreferences
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.UserData

class SharedPreferenceUserDataSource(
    private val sharedPreferences: SharedPreferences
) : UserDataSource {

    companion object {
        const val USER_ID_KEY = "userId"
        const val USER_NAME_KEY = "userName"
        const val USER_INFO_KEY = "userInfo"
    }

    init {
        val editor = sharedPreferences.edit()
        editor.putInt(USER_ID_KEY, 111)
        editor.putString(USER_NAME_KEY, "Petar")
        editor.putString(USER_INFO_KEY, "Neke informacije o Petru")
        editor.apply()
    }

    override fun getUserData(): Observable<UserData> {
        return Observable.fromCallable {
            val id = sharedPreferences.getLong(USER_ID_KEY, 0)
            val name = sharedPreferences.getString(USER_NAME_KEY, "") ?: ""
            val info = sharedPreferences.getString(USER_INFO_KEY, "") ?: ""
            UserData(id, name, info)
        }
    }

}