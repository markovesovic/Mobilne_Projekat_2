package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.notes

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Resource
import java.util.*

interface NotesRepository {

    fun getAll(): Observable<List<Note>>
//    fun getAllByName()
    fun insert(note: Note):Completable

}