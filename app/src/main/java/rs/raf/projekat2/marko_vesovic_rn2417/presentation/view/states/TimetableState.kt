package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.states

import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Lecture

sealed class TimetableState {
    object Loading: TimetableState()
    object DataFetched: TimetableState()
    data class Success(val lectures: List<Lecture>): TimetableState()
    data class Error(val message: String): TimetableState()
}