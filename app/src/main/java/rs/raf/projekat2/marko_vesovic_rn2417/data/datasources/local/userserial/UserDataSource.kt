package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.userserial

import rs.raf.projekat2.marko_vesovic_rn2417.data.models.UserData

interface UserDataSource {
    fun setUserData(userdata: UserData)
    fun getUserData(): UserData
    fun setLoggedIn(li: Boolean)
    fun getLoggedIn(): Boolean
}