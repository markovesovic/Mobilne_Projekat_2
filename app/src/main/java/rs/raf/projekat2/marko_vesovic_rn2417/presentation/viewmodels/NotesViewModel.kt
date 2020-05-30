package rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.NotesContract

class NotesViewModel() : ViewModel(), NotesContract.NotesViewModel {

    override val notes: LiveData<Unit> = MutableLiveData()

    override fun getNotes() {

    }


}