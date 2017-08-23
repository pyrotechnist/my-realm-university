package com.longyuan.my_realm_university.universitydetails;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.longyuan.my_realm_university.App;
import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.University.UniversityContarct;
import com.longyuan.my_realm_university.model.University;

import javax.inject.Inject;

public class UniversityDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_UNIVERSITY_ID = "University_ID";

    public static final int REQUEST_UPDATE_UNIVERSITY = 1;

    @Inject
    protected UniversityDetailsContract.Presenter mUniversityDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UniversityDetailsFragment universityDetailsFragment = (UniversityDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.frag_university_details_content);

        if(universityDetailsFragment == null)
        {
            universityDetailsFragment =  UniversityDetailsFragment.getInstance();

            getSupportFragmentManager().beginTransaction().add(R.id.frag_university_details_content,universityDetailsFragment).commit();

        }
        String universityId = getIntent().getStringExtra(EXTRA_UNIVERSITY_ID);

        DaggerUniversityDetailsComponent.builder()
                .appComponent(((App)getApplication()).getAppComponent())
                .universityDetailsModule(new UniversityDetailsModule(universityDetailsFragment,universityId))
                .build()
                .inject(this);


    }

}
