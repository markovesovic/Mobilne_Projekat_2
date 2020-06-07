package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.user

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User

interface UserRepository {
    fun getUser(): Observable<User>
    fun setUser(user: User): Completable
    fun isLoggedIn(): Observable<Boolean>
    fun setLoggedIn(li: Boolean): Completable
}