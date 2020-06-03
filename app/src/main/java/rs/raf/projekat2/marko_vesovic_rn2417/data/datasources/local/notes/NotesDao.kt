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

    @Query("SELECT * FROM notes")
    fun getAll(): Observable<List<NoteEntity>>

    @Query("DELETE FROM notes")
    fun deleteAll()

    @Transaction
    open fun deleteAndInsert(entities: List<NoteEntity>) {
        deleteAll()
        insertAll(entities).blockingAwait()
    }
}