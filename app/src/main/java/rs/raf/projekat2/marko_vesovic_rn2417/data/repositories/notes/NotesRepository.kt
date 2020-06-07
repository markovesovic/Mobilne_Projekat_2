package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.notes

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Resource
import java.util.*

interface NotesRepository {

    fun getAll(): Observable<List<Note>>
    fun getAllNonArchived(): Observable<List<Note>>
    fun getAllByFilter(filter: String): Observable<List<Note>>
    fun getAllNonArchivedByFilter(filter: String): Observable<List<Note>>
    fun insert(note: Note): Completable
    fun update(note: Note): Completable
    fun changeArchivedStatus(note: Note): Completable
    fun delete(note: Note): Completable
}