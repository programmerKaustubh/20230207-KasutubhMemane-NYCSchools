package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.ui.sat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SATScoreDto

class SatScoreViewModel(application: Application) : AndroidViewModel(application) {



    private var _dbn: MutableLiveData<String?>  = MutableLiveData<String?>()
    val dbn: LiveData<String?>
        get() = _dbn

    private var _numOfSatTestTakers = MutableLiveData<String?>()
    val numOfSatTestTakers: LiveData<String?>
        get() = _numOfSatTestTakers

    private var _satCriticalReadingAvgScore= MutableLiveData<String?>()
    val satCriticalReadingAvgScore: LiveData<String?>
        get() = _satCriticalReadingAvgScore

    private var _satMathAvgScore= MutableLiveData<String?>()
    val satMathAvgScore: LiveData<String?>
        get() = _satMathAvgScore


    private var _satWritingAvgScore= MutableLiveData<String?>()
    val satWritingAvgScore: LiveData<String?>
        get() = _satWritingAvgScore


    private var _schoolName= MutableLiveData<String?>()
    val schoolName: LiveData<String?>
        get() = _schoolName
    /**

    This function sets the value of the MutableLiveData objects with data from the SATScoreDto object
    @param satScoreDto SATScoreDto object containing the data to be set as the value for the MutableLiveData objects
     */
    fun getDataWithMessage(satScoreDto: SATScoreDto) {
        this._dbn.value ="DBN: " + satScoreDto.dbn
        this._numOfSatTestTakers.value = "Number of SAT Test Takers: " + satScoreDto.numOfSatTestTakers
        this._satCriticalReadingAvgScore.value = "SAT Critical Reading Avg Score: " + satScoreDto.satCriticalReadingAvgScore
        this._satMathAvgScore.value = "SAT Math Avg Score: " + satScoreDto.satMathAvgScore
        this._satWritingAvgScore.value = "SAT Writing Avg Score: " + satScoreDto.satWritingAvgScore
        this._schoolName.value = "School Name: " + satScoreDto.schoolName
    }
}