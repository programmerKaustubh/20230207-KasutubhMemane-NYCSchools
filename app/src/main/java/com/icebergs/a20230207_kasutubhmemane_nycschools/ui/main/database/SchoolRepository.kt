package     com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SatScoreResponse
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SchoolDTOEntity
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.network.SchoolApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import java.util.concurrent.Executors

enum class DatabaseStatus {
    LOADING, SUCCESS, ERROR, NO_DATA, NO_INTERNET, SAT_NO_DATA, SAT_ERROR
}

class SchoolRepository(application: Application?) {
    private val schoolApiService: SchoolApiService = SchoolApiService()
    val databaseStatusRepository: MutableLiveData<DatabaseStatus> = MutableLiveData()
    val schoolS: MutableLiveData<List<SchoolDTOEntity>> = MutableLiveData()
    val satScore: MutableLiveData<SatScoreResponse> = MutableLiveData()
    private val executor: Executor

    init {
        executor = Executors.newSingleThreadExecutor()
    }



    public fun downloadSchoolsDatabase() {
        val call = schoolApiService.schools
        databaseStatusRepository.value = DatabaseStatus.LOADING
        call.enqueue(object : Callback<List<SchoolDTOEntity>> {
            override fun onResponse(
                call: Call<List<SchoolDTOEntity>>,
                response: Response<List<SchoolDTOEntity>>
            ) {
                if (!response.isSuccessful) {
                    databaseStatusRepository.value = DatabaseStatus.ERROR
                    return
                } else if (response.code() == 401) {
                    databaseStatusRepository.value = DatabaseStatus.NO_INTERNET
                    return
                } else if (response.body()!!.isEmpty() || response.body()!![0] == null) {
                    databaseStatusRepository.value = DatabaseStatus.NO_DATA
                    return
                }
                val schoolReceived = response.body()
                 schoolReceived?.let {
                    schoolS.value  = it
                }
                databaseStatusRepository.value = DatabaseStatus.SUCCESS
            }

            override fun onFailure(call: Call<List<SchoolDTOEntity>>, t: Throwable) {
                t.printStackTrace()
                databaseStatusRepository.value = DatabaseStatus.ERROR
            }
        })
    }

    fun downloadSatScore(dbn: String) {
        val call = schoolApiService.getSATScore(dbn)
        databaseStatusRepository.value = DatabaseStatus.LOADING
        call.enqueue(object : Callback<List<SatScoreResponse>> {
            override fun onResponse(
                call: Call<List<SatScoreResponse>>,
                response: Response<List<SatScoreResponse>>
            ) {
                if (!response.isSuccessful) {
                    databaseStatusRepository.value = DatabaseStatus.SAT_NO_DATA
                    return
                } else if (response.body() != null && response.body()!!.isNotEmpty()
                    && response.body()!!.size >0) {
                    val satScoreReceived = SatScoreResponse(
                        response.body()?.get(0)?.dbn,
                        response.body()?.get(0)?.numOfSatTestTakers,
                        response.body()?.get(0)?.satCriticalReadingAvgScore,
                        response.body()?.get(0)?.satMathAvgScore,
                        response.body()?.get(0)?.satWritingAvgScore,
                        response.body()?.get(0)?.schoolName
                    )
                    satScore.value = satScoreReceived
                    databaseStatusRepository.value = DatabaseStatus.SUCCESS
                }else{
                    databaseStatusRepository.value = DatabaseStatus.SAT_ERROR
                }
            }

            override fun onFailure(call: Call<List<SatScoreResponse>>, t: Throwable) {
                t.printStackTrace()
                databaseStatusRepository.value = DatabaseStatus.SAT_ERROR
                Log.e("SchoolRepository", "onFailure: ", t)
            }
        })
    }
}