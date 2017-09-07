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

public class UniversityPresenter implements UniversityContract.Presenter {


    private UniversityContract.View mView;

    @Inject
    protected UniversityRepository mUniversityRepository;


    public UniversityPresenter(UniversityContract.View view) {

        mView = view;

        App.getAppComponent().inject(this);

        view.setPresnter(this);
    }


    @Override
    public void start() {

        loadUniversities();

    }


    public void loadUniversities() {

        loadUniversities(false);
    }

    @Override
    public void loadUniversities(boolean forceUpdate) {

        mUniversityRepository.loadAllUniversities(new DataStore.LoadUniversitiesCallback() {
            @Override
            public void onUniversitiesLoaded(List<University> universities) {
                mView.showUniversities(universities);
            }
        },forceUpdate);
    }

    @Override
    public void deleteUniversity(String id,int position) {

        mUniversityRepository.deleteUniversity(id, new DataStore.LoadOrUpdateUniversityCallback() {
            @Override
            public void onUniversityLoadedOrUpdated(University university) {
                if(id.equals(university.getId()))
                {
                    mView.deleteUniversityOnRecyclerView(position);
                }
            }
        });


    }

    @Override
    public void addUniversity(String id, String name) {
        mUniversityRepository.createUniversity(id,name,new DataStore.LoadOrUpdateUniversityCallback(){
            @Override
            public void onUniversityLoadedOrUpdated(University university) {

                if(id.equals(university.getId()))
                {
                    mView.addUniversityOnRecyclerView(university);
                }
            }
        });
    }


    public void loadUniversity(String universityId) {
        mView.showUniversityDetailsUi(universityId);

    }
}
