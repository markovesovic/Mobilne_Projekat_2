package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.notes.NotesDao
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.lecture.LectureDao
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.NoteEntity
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.LectureEntity


@Database(
    entities = [LectureEntity::class, NoteEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters()
abstract class Database: RoomDatabase() {
    abstract fun getLectureDao(): LectureDao
    abstract fun getNotesDao(): NotesDao
}