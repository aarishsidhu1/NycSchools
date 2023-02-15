package us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.api;

import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.model.School;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.model.SchoolDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("s3k6-pzi2.json?$limit=200")
    Call<List<School>> doListOfSchools();

    @GET("f9bf-2cp4.json?")
    Call<List<SchoolDetails>> doGetSchoolDetails(@Query("dbn") String dbn);
}

