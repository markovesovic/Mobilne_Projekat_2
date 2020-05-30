package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.schoolsubject

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.SchoolSubjectEntity

@Dao
abstract class SchoolSubjectDao {

    @Query("SELECT * FROM schoolSubjects")
    abstract fun getAll(): Observable<List<SchoolSubjectEntity>>

    @Query("DELETE FROM schoolSubjects")
    abstract fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(entities: List<SchoolSubjectEntity>): Completable

    @Transaction
    open fun deleteAndInsertAll(entities: List<SchoolSubjectEntity>) {
        deleteAll()
        insertAll(entities).blockingAwait()
    }

}