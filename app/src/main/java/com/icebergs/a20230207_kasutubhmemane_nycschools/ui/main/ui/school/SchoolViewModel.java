package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.ui.school;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;


import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.DatabaseStatus;
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.SchoolRepository;
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SATScoreDto;
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SatScoreResponse;
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SchoolDTOEntity;
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.util.NetworkUtils;

import java.util.List;

public class SchoolViewModel extends AndroidViewModel {

    private final MutableLiveData<List<SchoolDTOEntity>> schoolsVm;
    private final SchoolRepository schoolRepository;
    private final MutableLiveData<DatabaseStatus> databaseStatusVM;
    private final MutableLiveData<SATScoreDto> satScoreVM;
    private Context context;

    public MutableLiveData<DatabaseStatus> getDatabaseStatusVM() {
        return databaseStatusVM;
    }

    public MutableLiveData<List<SchoolDTOEntity>> getSchoolsVM() {
        return schoolsVm;
    }

    public MutableLiveData<SATScoreDto> getSatScoreVM() {
        return satScoreVM;
    }


    public SchoolViewModel(@NonNull Application application) {
        super(application);
        schoolRepository = new SchoolRepository(application);
        databaseStatusVM = new MutableLiveData<>();
        schoolsVm = new MutableLiveData<>();
        satScoreVM = new MutableLiveData<>();
        context = application.getApplicationContext();
        setObservers();
    }

    /**
     Sets the observers for the schoolRepository and updates the corresponding LiveData objects.
     */
    private void setObservers() {

        schoolRepository.getDatabaseStatusRepository().observeForever(databaseStatus -> databaseStatusVM.setValue(databaseStatus));
        schoolRepository.getSchoolS().observeForever(schoolDTOEntities -> schoolsVm.setValue(schoolDTOEntities));
        schoolRepository.getSatScore().observeForever(satDto -> {
            SATScoreDto satScoreDto = new SATScoreDto(satDto.getDbn(), satDto.getSchoolName(), satDto.getNumOfSatTestTakers(), satDto.getSatCriticalReadingAvgScore(), satDto.getSatMathAvgScore(), satDto.getSatWritingAvgScore());

            satScoreVM.setValue(satScoreDto);
        });
    }
    /**
     Downloads the schools database from the API if there is an internet connection.
     Otherwise, it sets the database status to NO_INTERNET.
     */
    public void downloadSchoolsDatabase() {
        if(NetworkUtils.isNetworkConnected(context)){
            schoolRepository.downloadSchoolsDatabase();
        }else{
            databaseStatusVM.setValue(DatabaseStatus.NO_INTERNET);
        }

    }
    /**
     Downloads the SAT score for a given school if there is an internet connection.
     Otherwise, it sets the database status to NO_INTERNET.
     @param dbn the identifier of the school.
     */
    public void downloadSatScore(String dbn) {
        if(NetworkUtils.isNetworkConnected(context)) {
            schoolRepository.downloadSatScore(dbn);
        }else {
            databaseStatusVM.setValue(DatabaseStatus.NO_INTERNET);
        }
    }
}