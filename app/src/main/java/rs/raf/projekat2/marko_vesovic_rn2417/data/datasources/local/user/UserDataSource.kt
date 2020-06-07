package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.user

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.UserData

interface UserDataSource {
    fun setUserData(userData: UserData): Completable
    fun getUserData(): Observable<UserData>
    fun setLoggedIn(is_logged_in: Boolean): Completable
    fun isLoggedIn(): Observable<Boolean>
}