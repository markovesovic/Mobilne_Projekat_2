package rs.raf.projekat2.marko_vesovic_rn2417.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.Database
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.notes.NotesRepository
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.notes.NotesRepositoryImplementation
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.NotesViewModel

val notesModule = module {

    viewModel { NotesViewModel(notesRepository = get()) }

    single<NotesRepository> { NotesRepositoryImplementation(localDataSource = get()) }

    single { get<Database>().getNotesDao() }

}