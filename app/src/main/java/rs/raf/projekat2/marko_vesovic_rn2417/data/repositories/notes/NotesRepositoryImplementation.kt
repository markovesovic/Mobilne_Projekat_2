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
                    Note(it.id,
                        it.title,
                        it.content,
                        it.archived)
                }
            }
    }

    override fun getAllByFilter(filter: String): Observable<List<Note>> {
        return localDataSource
            .getAllByFilter(filter)
            .map {
                it.map {
                    Note(it.id,
                    it.title,
                    it.content,
                    it.archived)
                }
            }
    }

    override fun getAllNonArchived(): Observable<List<Note>> {
        return localDataSource
            .getAllNonArchived()
            .map {
                it.map {
                    Note(
                        it.id,
                        it.title,
                        it.content,
                        it.archived
                    )
                }
            }
    }

    override fun getAllNonArchivedByFilter(filter: String): Observable<List<Note>> {
        return localDataSource
            .getAllNonArchivedByFilter(filter)
            .map {
                it.map {
                    Note(
                        it.id,
                        it.title,
                        it.content,
                        it.archived
                    )
                }
            }
    }

    override fun insert(note: Note): Completable {
        val noteEntity: NoteEntity = NoteEntity(
            note.id,
            note.title,
            note.content,
            note.archived)
        return localDataSource.insert(noteEntity)
    }

    override fun update(note: Note): Completable {
        return localDataSource
            .update(note.id, note.title, note.content)
    }

    override fun changeArchivedStatus(note: Note): Completable {
        return localDataSource
            .changeArchivedStatus(note.id, note.archived)
    }

    override fun delete(note: Note): Completable {
        return localDataSource
            .delete(note.id)
    }

}