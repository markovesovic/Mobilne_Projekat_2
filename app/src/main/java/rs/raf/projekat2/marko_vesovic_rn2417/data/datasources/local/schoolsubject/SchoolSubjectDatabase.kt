package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.schoolsubjects

import androidx.room.Database
import androidx.room.TypeConverters
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.SchoolSubject


@Database(
    entities =[SchoolSubject::class],
    version = 1,
    exportSchema = false
)
@TypeConverters
abstract class SchoolSubjectDatabase {
    abstract fun getSchoolSubjectDao(): SchoolSubjectDao
}