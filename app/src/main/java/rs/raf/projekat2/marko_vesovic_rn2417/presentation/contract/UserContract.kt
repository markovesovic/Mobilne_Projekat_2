package rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User

interface UserContract {

    interface ViewModel {
        val user: LiveData<User>
        val isLoggedIn: LiveData<Boolean>
        fun getUser(): User
        fun setUser(user: User)
        fun isLoggedIn(): Boolean
        fun setLoggedIn(li: Boolean)
    }

}