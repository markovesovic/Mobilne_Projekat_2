package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.user

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.user.UserDataSource
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.UserData
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.toUser

class UserRepositoryImplementation(
    private val userDataSource: UserDataSource
) : UserRepository {

    override fun getUser(): Observable<User> {
        return userDataSource
            .getUserData().map {
                it.toUser()
            }
    }

    override fun setUser(user: User): Completable {
        return Completable.fromCallable {
            userDataSource.setUserData(userData = UserData(
                user.username,
                user.password,
                ""
            ))
        }
    }

    override fun isLoggedIn(): Observable<Boolean> {
        return userDataSource.isLoggedIn()
    }

    override fun setLoggedIn(li: Boolean): Completable {
        return Completable.fromCallable {
            userDataSource.setLoggedIn(li)
        }
    }

}