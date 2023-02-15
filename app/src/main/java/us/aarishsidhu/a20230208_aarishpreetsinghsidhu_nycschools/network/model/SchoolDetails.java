package us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.model;

import com.google.gson.annotations.SerializedName;

public class SchoolDetails {
    @SerializedName("dbn")
    public String dbn;
    @SerializedName("school_name")
    public String schoolName;
    @SerializedName("num_of_sat_test_takers")
    public String satTestTakers;
    @SerializedName("sat_critical_reading_avg_score")
    public String readingScore;
    @SerializedName("sat_math_avg_score")
    public String mathScore;
    @SerializedName("sat_writing_avg_score")
    public String writingScore;
}

