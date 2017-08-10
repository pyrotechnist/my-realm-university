package com.longyuan.my_realm_university.University;

import com.longyuan.my_realm_university.App;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.DataStore;
import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by loxu on 07/08/2017.
 */

public class UniversityPresenter implements UniversityContarct.Presenter {


    private UniversityContarct.View mView;

    @Inject
    protected UniversityRepository mUniversityRepository;


    public UniversityPresenter(UniversityContarct.View view) {

        mView = view;

        App.getAppComponent().inject(this);

        view.setPresnter(this);
    }


    @Override
    public void start() {

        loadUniversities();

    }

    @Override
    public void loadUniversities() {

        mUniversityRepository.loadAllUniversities(new DataStore.LoadUniversitiesCallback() {
            @Override
            public void onUniversitiesLoaded(List<University> universities) {
                mView.showUniversities(universities);
            }
        });
    }
}
