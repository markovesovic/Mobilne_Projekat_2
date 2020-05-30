package rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.User
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.user.UserRepository
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.UserContract
import timber.log.Timber

class UserViewModel(private val userRepository: UserRepository): ViewModel(),
    UserContract.ViewModel {

    override val user: MutableLiveData<User> = MutableLiveData()

    private val subscriptions = CompositeDisposable()

    override fun getUser() {
        val subscription = userRepository
            .getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    user.value = it
                },
                {
                    Timber.e(it)
                },
                {

                }
            )
        subscriptions.add(subscription)
    }

    override fun onCleared() {
        subscriptions.dispose()
        super.onCleared()
    }
}