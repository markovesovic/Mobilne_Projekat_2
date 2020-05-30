package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.user

import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.user.UserDataSource
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.toUser

class UserRepositoryImplementation(private val userDataSource: UserDataSource) : UserRepository {

    override fun getUser(): Observable<User> {
        return userDataSource
            .getUserData().map {
                it.toUser()
            }
    }

}