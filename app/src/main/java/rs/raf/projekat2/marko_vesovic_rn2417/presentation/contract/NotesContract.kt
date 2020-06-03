package rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.states.NotesState

interface NotesContract {

    interface  ViewModel {

        val notesState: LiveData<NotesState>

        fun getAllNotes()
        fun addNote(note: Note)

    }

}