package com.longyuan.my_realm_university.realm.repository.impl;

import com.longyuan.my_realm_university.data.local.LocalDataStore;
import com.longyuan.my_realm_university.data.remote.RemoteDataStore;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.DataStore;
import com.longyuan.my_realm_university.realm.repository.IUniversityRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by loxu on 07/08/2017.
 */

public class UniversityRepository implements IUniversityRepository {

    private LocalDataStore mLocalDataStore;
    private RemoteDataStore mRemoteDataStore;

    private DataStore.LoadUniversitiesCallback mLoadUniversitiesCallback;

    @Inject
    public UniversityRepository(RemoteDataStore remoteDataStore, LocalDataStore localDataStore){
        this.mLocalDataStore = localDataStore;
        this.mRemoteDataStore = remoteDataStore;
    }


    @Override
    public void loadAllUniversities(DataStore.LoadUniversitiesCallback callback) {


        List<University> universities = new ArrayList<University>();
        //universities.addAll(mLocalDataStore.loadAllUniversities());

        //callback.onUniversitiesLoaded(universities);


        //mLocalDataStore.loadAllUniversities(callback);

        mRemoteDataStore.loadAllUniversities(callback);



    }

    @Override
    public void deleteUniversity(String id,DataStore.LoadOrUpdateUniversityCallback callback) {

        mRemoteDataStore.deleteUniversity(id, callback);

    }

    @Override
    public void createUniversity(String id,String name,DataStore.LoadOrUpdateUniversityCallback callback) {

        mRemoteDataStore.createUniversity(id,name, callback);

    }

    @Override
    public void loadUniversity(String id, DataStore.LoadOrUpdateUniversityCallback callback) {
        mRemoteDataStore.loadUniversity(id, callback);
    }

    @Override
    public void updateUniversity(String id, String name, DataStore.LoadOrUpdateUniversityCallback callback) {
        mRemoteDataStore.updateUniversity(id,name,callback);
    }

    @Override
    public void addStudentToUniversity(String id,String fk,DataStore.LoadOrUpdateUniversityCallback callback) {

    }

    @Override
    public void deleteStudentFromUniversity(String id,String fk,DataStore.LoadOrUpdateUniversityCallback callback) {
        mRemoteDataStore.deleteStudentFromUniversity(id,fk,callback);
    }
}
