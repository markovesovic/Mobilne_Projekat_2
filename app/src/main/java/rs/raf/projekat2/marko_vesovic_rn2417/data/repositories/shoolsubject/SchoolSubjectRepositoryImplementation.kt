package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.shoolsubject

import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.schoolsubject.SchoolSubjectDao
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.remote.SchoolSubjectService
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.SchoolSubject
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.SchoolSubjectEntity
import timber.log.Timber

class SchoolSubjectRepositoryImplementation(
    private val localDataSource: SchoolSubjectDao,
    private val remoteDataSource: SchoolSubjectService
): SchoolSubjectRepository {


//    override fun fetchAll(): Observable<Unit> {
//        return remoteDataSource
//            .getAll()
//            .doOnNext {
//                Timber.e("Upis u bazu")
//                val entities = it.map {
//                    SchoolSubjectEntity(
//                        it.name
//                    )
//                }
//            }
//    }

    override fun getAll(): Observable<List<SchoolSubject>> {
        return localDataSource
            .getAll()
            .map {
                it.map {
                    SchoolSubject(
                        it.name
                    )
                }
            }
    }



}