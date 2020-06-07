package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.userserial

import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.userserial.UserDataSource
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.UserData

class UserRepositoryImplementation(
    private val userDataSource: UserDataSource
): UserRepository {
    override fun getUser(): User {
        val userData = userDataSource.getUserData()
        return User(
            userData.username,
            userData.password
        )
    }

    override fun setUser(user: User) {
        userDataSource.setUserData(
            UserData(
            user.username,
            user.password,
            ""
        )
        )
    }

    override fun getLoggedIn(): Boolean {
        return userDataSource.getLoggedIn()
    }

    override fun setLoggedIn(li: Boolean) {
        userDataSource.setLoggedIn(li)
    }
}