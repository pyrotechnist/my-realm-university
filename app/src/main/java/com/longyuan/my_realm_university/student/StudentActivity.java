package com.longyuan.my_realm_university.student;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.longyuan.my_realm_university.App;
import com.longyuan.my_realm_university.R;

import javax.inject.Inject;

public class StudentActivity extends AppCompatActivity {

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! important
    @Inject
    protected StudentContract.Presenter mStudentPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        StudentFragment studentFragment = (StudentFragment) getSupportFragmentManager().findFragmentById(R.id.frag_students);

        if(studentFragment == null)
        {
            studentFragment = StudentFragment.getInstance();

            getSupportFragmentManager().beginTransaction().add(R.id.frag_students,studentFragment).commit();
        }

        DaggerStudentComponent.builder()
                .appComponent(((App)getApplication()).getAppComponent())
                .studentModule(new StudentModule(studentFragment))
                .build()
                .inject(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
