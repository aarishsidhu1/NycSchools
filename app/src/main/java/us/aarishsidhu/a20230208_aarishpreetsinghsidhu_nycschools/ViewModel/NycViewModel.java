package us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.model.School;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.model.SchoolDetails;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.repository.NycSchoolRepo;

import java.util.List;

public class NycViewModel extends ViewModel {

    NycSchoolRepo mNycSchoolRepo;
    public void init(){
        mNycSchoolRepo =  NycSchoolRepo.getInstance();
    }
    public MutableLiveData<List<School>> requestToFetchSchools(){
        return mNycSchoolRepo.getListOfSchools();
    }

    public MutableLiveData<List<SchoolDetails>> requestToFetchSchoolDetails(String dbn){
        return mNycSchoolRepo.getSchoolDetails(dbn);
    }
}