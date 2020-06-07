package rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Resource
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.lectures.LectureRepository
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.TimetableContract
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.states.TimetableState
import timber.log.Timber
import java.sql.Time
import java.util.concurrent.TimeUnit

class TimetableViewModel(
    private val lectureRepository: LectureRepository
): ViewModel(), TimetableContract.ViewModel {

    override val timetableState: MutableLiveData<TimetableState> = MutableLiveData()

    private val subscriptions = CompositeDisposable()

    override fun fetchAllLectures() {
        val subscription = lectureRepository
            .fetchAll()
            .startWith(Resource.Loading()) //Kada se pokrene fetch hocemo da postavimo stanje na Loading
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when(it) {
                        is Resource.Loading -> timetableState.value = TimetableState.Loading
                        is Resource.Success -> timetableState.value = TimetableState.DataFetched
                        is Resource.Error -> timetableState.value = TimetableState.Error("Error happened while fetching data from the server")
                    }
                },
                {
                    timetableState.value = TimetableState.Error("Error happened while fetching data from the server")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllLectures() {
        val subscription = lectureRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    timetableState.value = TimetableState.Success(it)
                },
                {
                    timetableState.value = TimetableState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllLecturesByFilters(group: String, day: String, searchText: String) {
        val subscription = lectureRepository
            .getByFilters(group, day, searchText)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    timetableState.value = TimetableState.Success(it)
                },
                {
                    timetableState.value = TimetableState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }

}