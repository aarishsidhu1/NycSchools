package us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.repository;

import androidx.lifecycle.MutableLiveData;

import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.api.ApiClient;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.api.ApiInterface;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.model.School;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.model.SchoolDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NycSchoolRepo {
    private static NycSchoolRepo instance;

    private static ApiInterface apiInterface;

    public static NycSchoolRepo getInstance(){
        if(instance == null){
            instance = new NycSchoolRepo();
        }
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        return instance;
    }

    public MutableLiveData<List<School>> getListOfSchools(){
        MutableLiveData<List<School>> listOfSchools = new MutableLiveData<>();
        apiInterface.doListOfSchools().enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                if(response.isSuccessful()){
                    listOfSchools.setValue(response.body());
                }else {
                    listOfSchools.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                listOfSchools.setValue(null);
            }
        });
        return listOfSchools;
    }

    public MutableLiveData<List<SchoolDetails>> getSchoolDetails(String dbn){
        MutableLiveData<List<SchoolDetails>> schoolDetails = new MutableLiveData<>();
        apiInterface.doGetSchoolDetails(dbn).enqueue(new Callback<List<SchoolDetails>>() {
            @Override
            public void onResponse(Call<List<SchoolDetails>> call, Response<List<SchoolDetails>> response) {
                if(response.isSuccessful()){
                    schoolDetails.setValue(response.body());
                }else {
                    schoolDetails.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<SchoolDetails>> call, Throwable t) {
                schoolDetails.setValue(null);
            }
        });
        return schoolDetails;
    }

}
