package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.states

import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note

sealed class NotesState {
    object Loading: NotesState()
    object DataFetched: NotesState()
    data class Success(val notes: List<Note>): NotesState()
    data class Error(val message: String): NotesState()
}