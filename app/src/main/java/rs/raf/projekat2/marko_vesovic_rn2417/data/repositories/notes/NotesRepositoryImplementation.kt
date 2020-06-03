package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.notes

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.notes.NotesDao
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.NoteEntity
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Resource

class NotesRepositoryImplementation(private val localDataSource: NotesDao) : NotesRepository {


    override fun getAll(): Observable<List<Note>> {
        return localDataSource
            .getAll()
            .map {
                it.map {
                    Note(it.id, it.title, it.content, it.archived)
                }
            }
    }

    override fun insert(note: Note): Completable {
        val noteEntity: NoteEntity = NoteEntity(note.id, note.title, note.content, note.archived)
        return localDataSource.insert(noteEntity)
    }

}