package rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract

import androidx.lifecycle.LiveData

interface MainContract {

    interface  NotesViewModel {
        val notes : LiveData<Unit>

        fun getNotes()
    }

}