package rs.raf.projekat2.marko_vesovic_rn2417.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.schoolsubject.SchoolSubjectDatabase
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.remote.SchoolSubjectService
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.shoolsubject.SchoolSubjectRepository
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.shoolsubject.SchoolSubjectRepositoryImplementation
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.SchoolSubjectsViewModel

val schoolSubjectModule = module {

    viewModel { SchoolSubjectsViewModel(schoolSubjectRepository = get()) }

    single<SchoolSubjectRepository> { SchoolSubjectRepositoryImplementation(localDataSource = get(), remoteDataSource = get()) }

    single { get<SchoolSubjectDatabase>().getSchoolSubjectDao() }

    single<SchoolSubjectService> { create(retrofit = get()) }

}