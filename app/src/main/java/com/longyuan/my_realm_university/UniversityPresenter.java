package com.longyuan.my_realm_university;

import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.DataSource;
import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by loxu on 07/08/2017.
 */

public class UniversityPresenter implements UniversityContarct.Presenter {


    private UniversityContarct.View mView;

    private UniversityRepository mUniversityRepository;

    @Inject
    UniversityPresenter(UniversityRepository universityRepository,UniversityContarct.View view) {

        mView = view;

        mUniversityRepository = universityRepository;
    }

    @Inject
    void setupListeners() {
        mView.setPresnter(this);
    }


    @Override
    public void start() {

        loadUniversities();

    }

    @Override
    public void loadUniversities() {

        mUniversityRepository.loadAllUniversities(new DataSource.LoadUniversitiesCallback() {
            @Override
            public void onUniversitiesLoaded(List<University> universities) {
                mView.showUniversities(universities);
            }
        });
    }
}
