package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.shoolsubjects

import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.schoolsubject.SchoolSubjectDao
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.remote.SchoolSubjectService
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.SchoolSubject

class SchoolSubjectRepositoryImplementation(
    private val localDataSource: SchoolSubjectDao,
    private val remoteDataSource: SchoolSubjectService
)/*: SchoolSubjectRepository*/ {


//    override fun fetchAll(): Observable<Unit> {
//
//    }
//
//    override fun getAll(): Observable<List<SchoolSubject>> {
//
//    }


}