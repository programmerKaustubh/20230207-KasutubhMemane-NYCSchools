package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.constants.ApplicationConstants;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = ApplicationConstants.SCHOOL_DATABASE)
public class SchoolDTOEntity {
    @PrimaryKey
    @NotNull
    @SerializedName("dbn")
    private String dbn;

    @ColumnInfo(name = "school_name")
    @SerializedName("school_name")
    private String schoolName;

    @ColumnInfo(name = "boro")
    @SerializedName("boro")
    private String boro;

    @ColumnInfo(name = "overview_paragraph")
    @SerializedName("overview_paragraph")
    private String overviewParagraph;

    @ColumnInfo(name = "school_10th_seats")
    @SerializedName("school_10th_seats")
    private String school10thSeats;

    @ColumnInfo(name = "academic_opportunities_1")
    @SerializedName("academicopportunities1")
    private String academicOpportunities1;

    @ColumnInfo(name = "academic_opportunities_2")
    @SerializedName("academicopportunities2")
    private String academicOpportunities2;

    @ColumnInfo(name = "ell_programs")
    @SerializedName("ell_programs")
    private String ellPrograms;

    @ColumnInfo(name = "neighborhood")
    @SerializedName("neighborhood")
    private String neighborhood;

    @ColumnInfo(name = "building_code")
    @SerializedName("building_code")
    private String buildingCode;

    @ColumnInfo(name = "location")
    @SerializedName("location")
    private String location;

    @ColumnInfo(name = "phone_number")
    @SerializedName("phone_number")
    private String phoneNumber;

    @ColumnInfo(name = "fax_number")
    @SerializedName("fax_number")
    private String faxNumber;

    @ColumnInfo(name = "school_email")
    @SerializedName("school_email")
    private String schoolEmail;

    @ColumnInfo(name = "website")
    @SerializedName("website")
    private String website;

    @ColumnInfo(name = "subway")
    @SerializedName("subway")
    private String subway;

    @ColumnInfo(name = "bus")
    @SerializedName("bus")
    private String bus;

    @ColumnInfo(name = "grades_2018")
    @SerializedName("grades2018")
    private String grades2018;

    @ColumnInfo(name = "final_grades")
    @SerializedName("finalgrades")
    private String finalGrades;

    @ColumnInfo(name = "total_students")
    @SerializedName("total_students")
    private String totalStudents;

    @ColumnInfo(name = "extracurricular_activities")
    @SerializedName("extracurricular_activities")
    private String extracurricularActivities;

    @ColumnInfo(name = "school_sports")
    @SerializedName("school_sports")
    private String schoolSports;

    @ColumnInfo(name = "attendance_rate")
    @SerializedName("attendance_rate")
    private String attendanceRate;


    @ColumnInfo(name = "pct_stu_enough_variety")
    @SerializedName("pct_stu_enough_variety")
    private String pctStuEnoughVariety;

    @ColumnInfo(name = "pct_stu_safe")
    @SerializedName("pct_stu_safe")
    private String pctStuSafe;

    @ColumnInfo(name = "school_accessibility_description")
    @SerializedName("school_accessibility_description")
    private String schoolAccessibilityDescription;

    @ColumnInfo(name = "directions1")
    @SerializedName("directions1")
    private String directions1;

    @ColumnInfo(name = "requirement1_1")
    @SerializedName("requirement1_1")
    private String requirement11;

    @ColumnInfo(name = "requirement2_1")
    @SerializedName("requirement2_1")
    private String requirement21;

    @ColumnInfo(name = "requirement3_1")
    @SerializedName("requirement3_1")
    private String requirement31;

    @ColumnInfo(name = "requirement4_1")
    @SerializedName("requirement4_1")
    private String requirement41;

    @ColumnInfo(name = "requirement5_1")
    @SerializedName("requirement5_1")
    private String requirement51;

    @ColumnInfo(name = "offer_rate1")
    @SerializedName("offer_rate1")
    private String offerRate1;

    @ColumnInfo(name = "program1")
    @SerializedName("program1")
    private String program1;

    @ColumnInfo(name = "code1")
    @SerializedName("code1")
    private String code1;

    @ColumnInfo(name = "interest1")
    @SerializedName("interest1")
    private String interest1;

    @ColumnInfo(name = "method1")
    @SerializedName("method1")
    private String method1;

    @ColumnInfo(name = "seats9ge1")
    @SerializedName("seats9ge1")
    private String seats9ge1;

    @ColumnInfo(name = "grade9gefilledflag1")
    @SerializedName("grade9gefilledflag1")
    private String grade9gefilledflag1;

    @ColumnInfo(name = "grade9geapplicants1")
    @SerializedName("grade9geapplicants1")
    private String grade9geapplicants1;


    @ColumnInfo(name = "seats9swd1")
    @SerializedName("seats9swd1")
    private String seats9swd1;

    @ColumnInfo(name = "grade9swdfilledflag1")
    @SerializedName("grade9swdfilledflag1")
    private String grade9swdfilledflag1;

    @ColumnInfo(name = "grade9swdapplicants1")
    @SerializedName("grade9swdapplicants1")
    private String grade9swdapplicants1;

    @ColumnInfo(name = "seats101")
    @SerializedName("seats101")
    private String seats101;

    @ColumnInfo(name = "eligibility1")
    @SerializedName("eligibility1")
    private String eligibility1;

    @ColumnInfo(name = "grade9geapplicantsperseat1")
    @SerializedName("grade9geapplicantsperseat1")
    private String grade9geApplicantsPerSeat1;

    @ColumnInfo(name = "grade9swdapplicantsperseat1")
    @SerializedName("grade9swdapplicantsperseat1")
    private String grade9swdApplicantsPerSeat1;

    @ColumnInfo(name = "primary_address_line_1")
    @SerializedName("primary_address_line_1")
    private String primaryAddressLine1;

    @ColumnInfo(name = "city")
    @SerializedName("city")
    private String city;

    @ColumnInfo(name = "zip")
    @SerializedName("zip")
    private String zip;

    @ColumnInfo(name = "state_code")
    @SerializedName("state_code")
    private String stateCode;

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    private String latitude;

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    private String longitude;

    @ColumnInfo(name = "community_board")
    @SerializedName("community_board")
    private String communityBoard;

    @ColumnInfo(name = "council_district")
    @SerializedName("council_district")
    private String councilDistrict;

    @ColumnInfo(name = "census_tract")
    @SerializedName("census_tract")
    private String censusTract;

    @ColumnInfo(name = "bin")
    @SerializedName("bin")
    private String bin;

    @ColumnInfo(name = "bbl")
    @SerializedName("bbl")
    private String bbl;

    @ColumnInfo(name = "nta")
    @SerializedName("nta")
    private String nta;

    @ColumnInfo(name = "borough")
    @SerializedName("borough")
    private String borough;

    public String getDbn() {
        return dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getBoro() {
        return boro;
    }

    public String getOverviewParagraph() {
        return overviewParagraph;
    }

    public String getSchool10thSeats() {
        return school10thSeats;
    }

    public String getAcademicOpportunities1() {
        return academicOpportunities1;
    }

    public String getAcademicOpportunities2() {
        return academicOpportunities2;
    }

    public String getEllPrograms() {
        return ellPrograms;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public String getWebsite() {
        return website;
    }

    public String getSubway() {
        return subway;
    }

    public String getBus() {
        return bus;
    }

    public String getGrades2018() {
        return grades2018;
    }

    public String getFinalGrades() {
        return finalGrades;
    }

    public String getTotalStudents() {
        return totalStudents;
    }

    public String getExtracurricularActivities() {
        return extracurricularActivities;
    }

    public String getSchoolSports() {
        return schoolSports;
    }

    public String getAttendanceRate() {
        return attendanceRate;
    }

    public String getPctStuEnoughVariety() {
        return pctStuEnoughVariety;
    }

    public String getPctStuSafe() {
        return pctStuSafe;
    }

    public String getSchoolAccessibilityDescription() {
        return schoolAccessibilityDescription;
    }

    public String getDirections1() {
        return directions1;
    }

    public String getRequirement11() {
        return requirement11;
    }

    public String getRequirement21() {
        return requirement21;
    }

    public String getRequirement31() {
        return requirement31;
    }

    public String getRequirement41() {
        return requirement41;
    }

    public String getRequirement51() {
        return requirement51;
    }

    public String getOfferRate1() {
        return offerRate1;
    }

    public String getProgram1() {
        return program1;
    }

    public String getCode1() {
        return code1;
    }

    public String getInterest1() {
        return interest1;
    }

    public String getMethod1() {
        return method1;
    }

    public String getSeats9ge1() {
        return seats9ge1;
    }

    public String getGrade9gefilledflag1() {
        return grade9gefilledflag1;
    }

    public String getGrade9geapplicants1() {
        return grade9geapplicants1;
    }

    public String getSeats9swd1() {
        return seats9swd1;
    }

    public String getGrade9swdfilledflag1() {
        return grade9swdfilledflag1;
    }

    public String getGrade9swdapplicants1() {
        return grade9swdapplicants1;
    }

    public String getSeats101() {
        return seats101;
    }

    public String getEligibility1() {
        return eligibility1;
    }

    public String getGrade9geApplicantsPerSeat1() {
        return grade9geApplicantsPerSeat1;
    }

    public String getGrade9swdApplicantsPerSeat1() {
        return grade9swdApplicantsPerSeat1;
    }

    public String getPrimaryAddressLine1() {
        return primaryAddressLine1;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCommunityBoard() {
        return communityBoard;
    }

    public String getCouncilDistrict() {
        return councilDistrict;
    }

    public String getCensusTract() {
        return censusTract;
    }

    public String getBin() {
        return bin;
    }

    public String getBbl() {
        return bbl;
    }

    public String getNta() {
        return nta;
    }

    public String getBorough() {
        return borough;
    }


    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setBoro(String boro) {
        this.boro = boro;
    }

    public void setOverviewParagraph(String overviewParagraph) {
        this.overviewParagraph = overviewParagraph;
    }

    public void setSchool10thSeats(String school10thSeats) {
        this.school10thSeats = school10thSeats;
    }

    public void setAcademicOpportunities1(String academicOpportunities1) {
        this.academicOpportunities1 = academicOpportunities1;
    }

    public void setAcademicOpportunities2(String academicOpportunities2) {
        this.academicOpportunities2 = academicOpportunities2;
    }

    public void setEllPrograms(String ellPrograms) {
        this.ellPrograms = ellPrograms;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setSubway(String subway) {
        this.subway = subway;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public void setGrades2018(String grades2018) {
        this.grades2018 = grades2018;
    }

    public void setFinalGrades(String finalGrades) {
        this.finalGrades = finalGrades;
    }

    public void setTotalStudents(String totalStudents) {
        this.totalStudents = totalStudents;
    }

    public void setExtracurricularActivities(String extracurricularActivities) {
        this.extracurricularActivities = extracurricularActivities;
    }

    public void setSchoolSports(String schoolSports) {
        this.schoolSports = schoolSports;
    }

    public void setAttendanceRate(String attendanceRate) {
        this.attendanceRate = attendanceRate;
    }

    public void setPctStuEnoughVariety(String pctStuEnoughVariety) {
        this.pctStuEnoughVariety = pctStuEnoughVariety;
    }

    public void setPctStuSafe(String pctStuSafe) {
        this.pctStuSafe = pctStuSafe;
    }

    public void setSchoolAccessibilityDescription(String schoolAccessibilityDescription) {
        this.schoolAccessibilityDescription = schoolAccessibilityDescription;
    }

    public void setDirections1(String directions1) {
        this.directions1 = directions1;
    }

    public void setRequirement11(String requirement11) {
        this.requirement11 = requirement11;
    }

    public void setRequirement21(String requirement21) {
        this.requirement21 = requirement21;
    }

    public void setRequirement31(String requirement31) {
        this.requirement31 = requirement31;
    }

    public void setRequirement41(String requirement41) {
        this.requirement41 = requirement41;
    }

    public void setRequirement51(String requirement51) {
        this.requirement51 = requirement51;
    }

    public void setOfferRate1(String offerRate1) {
        this.offerRate1 = offerRate1;
    }

    public void setProgram1(String program1) {
        this.program1 = program1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public void setMethod1(String method1) {
        this.method1 = method1;
    }

    public void setSeats9ge1(String seats9ge1) {
        this.seats9ge1 = seats9ge1;
    }

    public void setGrade9gefilledflag1(String grade9gefilledflag1) {
        this.grade9gefilledflag1 = grade9gefilledflag1;
    }

    public void setGrade9geapplicants1(String grade9geapplicants1) {
        this.grade9geapplicants1 = grade9geapplicants1;
    }

    public void setSeats9swd1(String seats9swd1) {
        this.seats9swd1 = seats9swd1;
    }

    public void setGrade9swdfilledflag1(String grade9swdfilledflag1) {
        this.grade9swdfilledflag1 = grade9swdfilledflag1;
    }

    public void setGrade9swdapplicants1(String grade9swdapplicants1) {
        this.grade9swdapplicants1 = grade9swdapplicants1;
    }

    public void setSeats101(String seats101) {
        this.seats101 = seats101;
    }

    public void setEligibility1(String eligibility1) {
        this.eligibility1 = eligibility1;
    }

    public void setGrade9geApplicantsPerSeat1(String grade9geApplicantsPerSeat1) {
        this.grade9geApplicantsPerSeat1 = grade9geApplicantsPerSeat1;
    }

    public void setGrade9swdApplicantsPerSeat1(String grade9swdApplicantsPerSeat1) {
        this.grade9swdApplicantsPerSeat1 = grade9swdApplicantsPerSeat1;
    }

    public void setPrimaryAddressLine1(String primaryAddressLine1) {
        this.primaryAddressLine1 = primaryAddressLine1;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setCommunityBoard(String communityBoard) {
        this.communityBoard = communityBoard;
    }

    public void setCouncilDistrict(String councilDistrict) {
        this.councilDistrict = councilDistrict;
    }

    public void setCensusTract(String censusTract) {
        this.censusTract = censusTract;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public void setBbl(String bbl) {
        this.bbl = bbl;
    }

    public void setNta(String nta) {
        this.nta = nta;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public SchoolDTOEntity(String dbn, String schoolName, String boro, String overviewParagraph, String school10thSeats, String academicOpportunities1, String academicOpportunities2, String ellPrograms, String neighborhood, String buildingCode, String location, String phoneNumber, String faxNumber, String schoolEmail, String website, String subway, String bus, String grades2018, String finalGrades, String totalStudents, String extracurricularActivities, String schoolSports, String attendanceRate, String pctStuEnoughVariety, String pctStuSafe, String schoolAccessibilityDescription, String directions1, String requirement11, String requirement21, String requirement31, String requirement41, String requirement51, String offerRate1, String program1, String code1, String interest1, String method1, String seats9ge1, String grade9gefilledflag1, String grade9geapplicants1, String seats9swd1, String grade9swdfilledflag1, String grade9swdapplicants1, String seats101, String eligibility1, String grade9geApplicantsPerSeat1, String grade9swdApplicantsPerSeat1, String primaryAddressLine1, String city, String zip, String stateCode, String latitude, String longitude, String communityBoard, String councilDistrict, String censusTract, String bin, String bbl, String nta, String borough) {
        this.dbn = dbn;
        this.schoolName = schoolName;
        this.boro = boro;
        this.overviewParagraph = overviewParagraph;
        this.school10thSeats = school10thSeats;
        this.academicOpportunities1 = academicOpportunities1;
        this.academicOpportunities2 = academicOpportunities2;
        this.ellPrograms = ellPrograms;
        this.neighborhood = neighborhood;
        this.buildingCode = buildingCode;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.schoolEmail = schoolEmail;
        this.website = website;
        this.subway = subway;
        this.bus = bus;
        this.grades2018 = grades2018;
        this.finalGrades = finalGrades;
        this.totalStudents = totalStudents;
        this.extracurricularActivities = extracurricularActivities;
        this.schoolSports = schoolSports;
        this.attendanceRate = attendanceRate;
        this.pctStuEnoughVariety = pctStuEnoughVariety;
        this.pctStuSafe = pctStuSafe;
        this.schoolAccessibilityDescription = schoolAccessibilityDescription;
        this.directions1 = directions1;
        this.requirement11 = requirement11;
        this.requirement21 = requirement21;
        this.requirement31 = requirement31;
        this.requirement41 = requirement41;
        this.requirement51 = requirement51;
        this.offerRate1 = offerRate1;
        this.program1 = program1;
        this.code1 = code1;
        this.interest1 = interest1;
        this.method1 = method1;
        this.seats9ge1 = seats9ge1;
        this.grade9gefilledflag1 = grade9gefilledflag1;
        this.grade9geapplicants1 = grade9geapplicants1;
        this.seats9swd1 = seats9swd1;
        this.grade9swdfilledflag1 = grade9swdfilledflag1;
        this.grade9swdapplicants1 = grade9swdapplicants1;
        this.seats101 = seats101;
        this.eligibility1 = eligibility1;
        this.grade9geApplicantsPerSeat1 = grade9geApplicantsPerSeat1;
        this.grade9swdApplicantsPerSeat1 = grade9swdApplicantsPerSeat1;
        this.primaryAddressLine1 = primaryAddressLine1;
        this.city = city;
        this.zip = zip;
        this.stateCode = stateCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.communityBoard = communityBoard;
        this.councilDistrict = councilDistrict;
        this.censusTract = censusTract;
        this.bin = bin;
        this.bbl = bbl;
        this.nta = nta;
        this.borough = borough;
    }
}