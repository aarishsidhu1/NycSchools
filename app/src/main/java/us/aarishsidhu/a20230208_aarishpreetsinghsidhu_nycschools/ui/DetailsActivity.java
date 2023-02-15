package us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.R;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.model.SchoolDetails;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.ViewModel.NycViewModel;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    NycViewModel viewModel;
    TextView tvName,tvTotalTestTakers,tvReadingScore,tvWritingScore,tvMathScore;
    String dbn="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        viewModel = new ViewModelProvider(this).get(NycViewModel.class);
        viewModel.init();
        tvName = findViewById(R.id.tv_school_name);
        tvTotalTestTakers = findViewById(R.id.tv_test_takers_value);
        tvReadingScore = findViewById(R.id.tv_reading_value);
        tvWritingScore = findViewById(R.id.tv_writing_value);
        tvMathScore = findViewById(R.id.tv_math_value);
        dbn = getIntent().getExtras().getString("DBN","");

        fetchSchoolDetails(dbn);
    }

    private void fetchSchoolDetails(String dbn) {
        viewModel.requestToFetchSchoolDetails(dbn).observe(this, schoolDetails -> {
            if(schoolDetails!= null && !schoolDetails.isEmpty()){
                SchoolDetails details = schoolDetails.get(0);
                tvMathScore.setText(details.mathScore);
                tvTotalTestTakers.setText(details.satTestTakers);
                tvReadingScore.setText(details.readingScore);
                tvWritingScore.setText(details.writingScore);
                tvName.setText(details.schoolName);
            }else {
                Toast.makeText(DetailsActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}