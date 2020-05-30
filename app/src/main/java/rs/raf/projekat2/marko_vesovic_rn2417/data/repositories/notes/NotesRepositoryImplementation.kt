package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories

import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.NotesDataSource

class NotesRepositoryImplementation(private val notesDataSource: NotesDataSource) : NotesRepository {

    override fun getNotes(): Unit {

    }

}