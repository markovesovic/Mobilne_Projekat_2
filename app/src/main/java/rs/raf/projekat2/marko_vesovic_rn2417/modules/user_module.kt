package rs.raf.projekat2.marko_vesovic_rn2417.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.userserial.SharedPreferenceUserDataSource
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.userserial.UserDataSource
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.userserial.UserRepository
import rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.userserial.UserRepositoryImplementation
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.UserViewModel

val userModule = module {

    viewModel { UserViewModel(userRepository = get()) }

    single<UserRepository> { UserRepositoryImplementation(userDataSource = get()) }

    single<UserDataSource> { SharedPreferenceUserDataSource(sharedPreferences = get()) }
}