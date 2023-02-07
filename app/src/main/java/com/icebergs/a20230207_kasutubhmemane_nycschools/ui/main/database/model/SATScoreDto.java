package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;



public class SATScoreDto implements Parcelable {

    @SerializedName("dbn")
    public String dbn="";

    @SerializedName("school_name")
    public String schoolName="";

    @SerializedName("num_of_sat_test_takers")
    public String numOfSatTestTakers="";

    @SerializedName("sat_critical_reading_avg_score")
    public String satCriticalReadingAvgScore="";

    @SerializedName("sat_math_avg_score")
    public String satMathAvgScore="";

    @SerializedName("sat_writing_avg_score")
    public String satWritingAvgScore="";

    public SATScoreDto(Parcel in) {
        dbn = in.readString();
        schoolName = in.readString();
        numOfSatTestTakers = in.readString();
        satCriticalReadingAvgScore = in.readString();
        satMathAvgScore = in.readString();
        satWritingAvgScore = in.readString();
    }

    public static final Creator<SATScoreDto> CREATOR = new Creator<SATScoreDto>() {
        @Override
        public SATScoreDto createFromParcel(Parcel in) {
            return new SATScoreDto(in);
        }

        @Override
        public SATScoreDto[] newArray(int size) {
            return new SATScoreDto[size];
        }
    };

    public SATScoreDto(String dbn, String schoolName, String numOfSatTestTakers, String satCriticalReadingAvgScore, String satMathAvgScore, String satWritingAvgScore) {
        this.dbn = dbn;
        this.schoolName = schoolName;
        this.numOfSatTestTakers = numOfSatTestTakers;
        this.satCriticalReadingAvgScore = satCriticalReadingAvgScore;
        this.satMathAvgScore = satMathAvgScore;
        this.satWritingAvgScore = satWritingAvgScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(dbn);
        parcel.writeString(schoolName);
        parcel.writeString(numOfSatTestTakers);
        parcel.writeString(satCriticalReadingAvgScore);
        parcel.writeString(satMathAvgScore);
        parcel.writeString(satWritingAvgScore);
    }
}