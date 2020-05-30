package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.user

import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.UserData

interface UserDataSource {
    fun getUserData() : Observable<UserData>
}