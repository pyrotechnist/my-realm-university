package com.longyuan.my_realm_university;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import javax.inject.Inject;

import static com.longyuan.my_realm_university.R.id.fab;

public class UniversityActivity extends AppCompatActivity {


    //@Inject UniversityPresenter mUniversityPresenter;

    @Inject UniversityRepository mUniversityRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        App.getUniversityRepositoryComponent().inject(this);

        UniversityFragment universityFragment = (UniversityFragment)getSupportFragmentManager().findFragmentById(R.id.frag_content);

        if(universityFragment == null)
        {
            universityFragment = UniversityFragment.getInstance();

            getSupportFragmentManager().beginTransaction().add(R.id.frag_content,universityFragment).commit();
        }


       /* DaggerUniversityComponent.builder()
                .universityPresenterModule(new UniversityPresenterModule(universityFragment, mUniversityRepository))
                .build()
                .inject(this);*/

       new UniversityPresenter(mUniversityRepository,universityFragment);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

        return super.onOptionsItemSelected(item);
    }
}
