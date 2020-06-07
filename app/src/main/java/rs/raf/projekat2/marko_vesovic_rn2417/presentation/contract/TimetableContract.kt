package rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.states.TimetableState

interface TimetableContract {

    interface ViewModel {
        val timetableState: LiveData<TimetableState>

        fun fetchAllLectures()
        fun getAllLectures()
        fun getAllLecturesByFilters(group: String, day: String, searchText: String)

    }

}