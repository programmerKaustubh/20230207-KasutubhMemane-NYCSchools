package     com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.network


import com.google.gson.GsonBuilder
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.constants.ApplicationURIGenerator
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SatScoreResponse
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SchoolDTOEntity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

class SchoolApiService {
    private val schoolAPIService: SchoolAPIService
    private val TIME_OUT : Long= 10
    init {
        val gson = GsonBuilder().setLenient().create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.HEADERS }
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }


        val clientOkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(ApplicationURIGenerator.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(clientOkHttpClient)
            .build()
        schoolAPIService = retrofit.create(SchoolAPIService::class.java)
    }


    private interface SchoolAPIService {
        @GET(ApplicationURIGenerator.DOE_HIGH_SCHOOL_DIRECTORY)
        fun getSchools(@Header("X-App-Token") token: String?): Call<List<SchoolDTOEntity>>

        @GET(ApplicationURIGenerator.SAT_SCORES)
        fun getSATScoreByDbn(@Query("dbn") dbn: String): Call<List<SatScoreResponse>>
    }

    val schools: Call<List<SchoolDTOEntity>>
        get() = schoolAPIService.getSchools(ApplicationURIGenerator.ACCESS_TOKEN)

    fun getSATScore(dbn: String): Call<List<SatScoreResponse>> {
        return schoolAPIService.getSATScoreByDbn(dbn)
    }
}