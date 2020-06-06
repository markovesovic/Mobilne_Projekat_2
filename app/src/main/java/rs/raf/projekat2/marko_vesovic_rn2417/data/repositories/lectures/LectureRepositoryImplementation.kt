package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.lectures

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.lecture.LectureDao
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.remote.LectureService
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Lecture
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Resource

class LectureRepositoryImplementation(
    private val localDataSource: LectureDao,
    private val remoteDataSource: LectureService
) : LectureRepository {

    override fun fetchAll(): Observable<Resource<Unit>> {
        TODO("Not yet implemented")
    }

    override fun getAll(): Observable<List<Lecture>> {
        TODO("Not yet implemented")
    }

    override fun getAllByName(name: String): Observable<List<Lecture>> {
        TODO("Not yet implemented")
    }

    override fun insert(lecture: Lecture): Completable {
        TODO("Not yet implemented")
    }

}