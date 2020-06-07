package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.notes

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.NoteEntity

@Dao
interface NotesDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: NoteEntity): Completable

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<NoteEntity>): Completable

    //Sve
    @Query("SELECT * FROM notes")
    fun getAll(): Observable<List<NoteEntity>>
    //Sve koje nisu arhivirane
    @Query("SELECT * FROM notes WHERE archived = 0")
    fun getAllNonArchived(): Observable<List<NoteEntity>>
    //Sve po filteru
    @Query("SELECT * FROM notes WHERE title LIKE '%' || :filter || '%' OR content LIKE '%' || :filter || '%' ")
    fun getAllByFilter(filter: String): Observable<List<NoteEntity>>
    //Sve koje nisu arhivirane po filteru
    @Query("SELECT * FROM notes WHERE (title LIKE '%' || :filter || '%' OR content LIKE '%' || :filter || '%') AND archived = 0")
    fun getAllNonArchivedByFilter(filter: String): Observable<List<NoteEntity>>




    @Query("UPDATE notes SET content = :content, title = :title WHERE id = :id")
    fun update(id: Long, title: String, content: String): Completable

    @Query("UPDATE notes SET archived = :archived WHERE id = :id")
    fun changeArchivedStatus(id: Long, archived: Boolean): Completable

    @Query("DELETE FROM notes WHERE id = :id")
    fun delete(id: Long): Completable






    @Query("DELETE FROM notes")
    fun deleteAll()

    @Transaction
    open fun deleteAndInsert(entities: List<NoteEntity>) {
        deleteAll()
        insertAll(entities).blockingAwait()
    }
}