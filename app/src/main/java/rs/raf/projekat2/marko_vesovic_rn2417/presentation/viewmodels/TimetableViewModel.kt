package rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.lectures.LectureRepository
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.TimetableContract

class TimetableViewModel(
    private val lectureRepository: LectureRepository
): ViewModel(), TimetableContract.ViewModel {

    val subscription = CompositeDisposable()

    override fun getAllLectures() {
        val subscription = lectureRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                },
                {

                }
            )
    }


}