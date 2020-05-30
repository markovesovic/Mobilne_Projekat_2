package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.user

import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User

interface UserRepository {
    fun getUser() : Observable<User>
}