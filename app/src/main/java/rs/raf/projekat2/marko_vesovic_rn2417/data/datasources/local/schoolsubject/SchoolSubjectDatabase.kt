package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.schoolsubject

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.SchoolSubjectEntity


@Database(
    entities = [SchoolSubjectEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters()
abstract class SchoolSubjectDatabase: RoomDatabase() {
    abstract fun getSchoolSubjectDao(): SchoolSubjectDao
}