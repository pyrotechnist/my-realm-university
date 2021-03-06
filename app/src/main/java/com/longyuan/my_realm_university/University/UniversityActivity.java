package com.longyuan.my_realm_university.University;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.longyuan.my_realm_university.App;
import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.student.StudentActivity;

import javax.inject.Inject;

import static java.security.AccessController.getContext;

public class UniversityActivity extends AppCompatActivity{


    @Inject
    protected UniversityContract.Presenter mUniversityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UniversityFragment universityFragment = (UniversityFragment)getSupportFragmentManager().findFragmentById(R.id.frag_content);

        if(universityFragment == null)
        {
            universityFragment = UniversityFragment.getInstance();

            getSupportFragmentManager().beginTransaction().add(R.id.frag_content,universityFragment).commit();
        }


       DaggerUniversityComponent.builder()
                .appComponent(((App)getApplication()).getAppComponent())
                .universityModule(new UniversityModule(universityFragment))
                .build()
                .inject(this);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*//*

              *//*  AlertDialog.Builder builder = new AlertDialog.Builder(UniversityActivity.this);
                // Add the buttons
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

                AlertDialog dialog = builder.create();

                dialog.show();*//*


                FragmentManager fragmentManager = getSupportFragmentManager();

                AddUniversityDialogFragment addUniversityDialogFragment = new AddUniversityDialogFragment();

                addUniversityDialogFragment.show(fragmentManager,"addUniversityDialogFragment");


            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_students) {
            Intent intent = new Intent(this, StudentActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }



}
