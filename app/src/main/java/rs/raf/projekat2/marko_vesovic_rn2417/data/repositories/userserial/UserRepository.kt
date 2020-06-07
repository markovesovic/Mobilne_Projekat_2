package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.userserial

import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User

interface UserRepository {
    fun getUser(): User
    fun setUser(user: User)
    fun getLoggedIn(): Boolean
    fun setLoggedIn(li: Boolean)
}