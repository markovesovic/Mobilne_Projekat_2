package rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.shoolsubject.SchoolSubjectRepository
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.SchoolSubjectContract

class SchoolSubjectsViewModel(
    private val schoolSubjectRepository: SchoolSubjectRepository
): ViewModel(), SchoolSubjectContract.ViewModel {

    val subscription = CompositeDisposable()

    override fun getAllSchoolSubjects() {
        val subscription = schoolSubjectRepository
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