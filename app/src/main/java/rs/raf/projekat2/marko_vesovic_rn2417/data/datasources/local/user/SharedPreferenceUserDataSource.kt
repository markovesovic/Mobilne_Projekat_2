package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.user

import android.content.SharedPreferences
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.UserData

class SharedPreferenceUserDataSource(
    private val sharedPreferences: SharedPreferences
) : UserDataSource {

    companion object {
        const val USER_NAME_KEY = "userName"
        const val PASSWORD_KEY = "password"
        const val USER_INFO_KEY = "userInfo"
        const val IS_LOGGED_IN = "isUserLoggedIn"
    }
    private var editor: SharedPreferences.Editor = sharedPreferences.edit()

    init {
//        editor.putBoolean(IS_LOGGED_IN, false)
//        editor.commit()

//        editor.putInt(USER_ID_KEY, 111)
//        editor.putString(USER_NAME_KEY, "Petar")
//        editor.putString(USER_INFO_KEY, "Neke informacije o Petru")
//        editor.apply()
    }

    override fun setUserData(userData: UserData): Completable {
        return Completable.fromCallable {
            editor.putString(USER_NAME_KEY, userData.username)
            editor.putString(PASSWORD_KEY, userData.password)
            editor.putString(USER_INFO_KEY, userData.info)
            editor.commit()
        }
    }

    override fun getUserData(): Observable<UserData> {
        return Observable.fromCallable {
            val username = sharedPreferences.getString(USER_NAME_KEY, "") ?: ""
            val password = sharedPreferences.getString(PASSWORD_KEY, "") ?: ""
            val userInfo = sharedPreferences.getString(USER_INFO_KEY, "") ?: ""
            UserData(username, password, userInfo)
        }
    }

    override fun setLoggedIn(is_logged_in: Boolean): Completable {
        return Completable.fromCallable {
            editor.putBoolean(IS_LOGGED_IN, is_logged_in)
            editor.commit()
        }
    }

    override fun isLoggedIn(): Observable<Boolean> {
        return Observable.fromCallable {
            sharedPreferences.getBoolean(IS_LOGGED_IN, false)
        }
    }
}