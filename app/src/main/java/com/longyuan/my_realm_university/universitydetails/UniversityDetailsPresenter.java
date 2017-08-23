package com.longyuan.my_realm_university.universitydetails;

import com.longyuan.my_realm_university.App;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.DataStore;
import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import javax.inject.Inject;

/**
 * Created by loxu on 22/08/2017.
 */

public class UniversityDetailsPresenter implements UniversityDetailsContract.Presenter {


    private UniversityDetailsContract.View mView;

    private String mUniversityId;

    @Inject
    protected UniversityRepository mUniversityRepository;


    public UniversityDetailsPresenter(UniversityDetailsContract.View view,String universityId) {

        mView = view;

        mUniversityId = universityId;

        App.getAppComponent().inject(this);

        view.setPresnter(this);
    }


    @Override
    public void start() {
        loadUniversity(mUniversityId);

    }

    @Override
    public void loadUniversity(String universityId) {
        mUniversityRepository.loadUniversity(universityId, new DataStore.DeleteUniversityCallback() {
            @Override
            public void onUniversityDeleted(University university) {
                mView.showUniversity(university);
            }
        });

    }

    @Override
    public void updateUniversity(String id, String name) {

        mUniversityRepository.updateUniversity(id,name,new DataStore.DeleteUniversityCallback(){

            @Override
            public void onUniversityDeleted(University university) {

                if(id.equals(university.getId()))
                {
                    mView.refreshUniversitiesDetailsUi(university.getId());
                }

            }
        });
    }
}
