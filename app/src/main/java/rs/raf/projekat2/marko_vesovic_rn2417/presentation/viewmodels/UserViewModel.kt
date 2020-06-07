package rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.userserial.UserRepository
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.UserContract
import timber.log.Timber

class UserViewModel(
    private val userRepository: UserRepository
): ViewModel(), UserContract.ViewModel {

    override val user: MutableLiveData<User> = MutableLiveData()

    override val isLoggedIn: MutableLiveData<Boolean> = MutableLiveData()

    override fun getUser(): User {
        return userRepository.getUser()
    }

    override fun setUser(user: User) {
        userRepository.setUser(user)
    }

    override fun isLoggedIn(): Boolean {
        return userRepository.getLoggedIn()
    }

    override fun setLoggedIn(li: Boolean) {
        userRepository.setLoggedIn(li)
    }

//    private val subscriptions = CompositeDisposable()
//
//    override fun getUser() {
//        val subscription = userRepository
//            .getUser()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
//                    user.value = it
//                },
//                {
//                    Timber.e(it)
//                },
//                {
//
//                }
//            )
//        subscriptions.add(subscription)
//    }
//
//    override fun setUser(user: User) {
//        val subscription = userRepository
//            .setUser(user)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe()
//        subscriptions.add(subscription)
//    }
//
//    override fun isLoggedIn() {
//        val subscription = userRepository
//            .isLoggedIn()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
//                    isLoggedIn.value = it
//                },
//                {
//
//                }
//            )
//        subscriptions.add(subscription)
//    }
//
//    override fun setLoggedIn(li: Boolean) {
//        val subscription = userRepository
//            .setLoggedIn(li)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe()
//        subscriptions.add(subscription)
//    }
//
//    override fun onCleared() {
//        subscriptions.dispose()
//        super.onCleared()
//    }
}