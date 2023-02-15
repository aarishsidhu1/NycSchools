package us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.R;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.ViewModel.NycViewModel;

public class MainActivity extends AppCompatActivity {
    NycViewModel viewModel;
    RecyclerView rvSchools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(NycViewModel.class);
        viewModel.init();
        rvSchools  = findViewById(R.id.rv_schools);
        rvSchools.setHasFixedSize(true);
        rvSchools.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvSchools.addItemDecoration(new DividerItemDecoration(rvSchools.getContext(), DividerItemDecoration.VERTICAL));

        fetchSchools();

    }

    private void fetchSchools() {
        viewModel.requestToFetchSchools().observe(this, schools -> {
            Log.i("TAG", "onChanged: schools "+schools.size());
            if(schools != null && schools.size() > 0){
                rvSchools.setAdapter(new NycSchoolAdapter(getApplicationContext(),schools));
            }
        });
    }

}