package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.lecture

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.LectureEntity

@Dao
abstract class LectureDao {

    @Query("SELECT * FROM timetable")
    abstract fun getAll(): Observable<List<LectureEntity>>

    @Query("DELETE FROM timetable")
    abstract fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(entities: List<LectureEntity>): Completable

    @Transaction
    open fun deleteAndInsertAll(entities: List<LectureEntity>) {
        deleteAll()
        insertAll(entities).blockingAwait()
    }

    @Query("SELECT * FROM timetable WHERE groups LIKE '%' || :group || '%' AND day LIKE '%' || :day || '%' AND (teacher LIKE '%' || :searchText || '%' OR name LIKE '%' || :searchText || '%')")
    abstract fun getByFilters(group: String, day: String, searchText: String): Observable<List<LectureEntity>>

}