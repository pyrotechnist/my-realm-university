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

    private List<University> mUniversitiesCache;

    private DataStore.LoadUniversitiesCallback mLoadUniversitiesCallback;

    @Inject
    public UniversityRepository(RemoteDataStore remoteDataStore, LocalDataStore localDataStore){
        this.mLocalDataStore = localDataStore;
        this.mRemoteDataStore = remoteDataStore;
    }



    public void loadAllUniversities(DataStore.LoadUniversitiesCallback callback) {


        loadAllUniversities(callback,false);
   }

    @Override
    public void loadAllUniversities(DataStore.LoadUniversitiesCallback callback,boolean forceUpdate) {


        List<University> universities = new ArrayList<University>();
        //universities.addAll(mLocalDataStore.loadAllUniversities());

        //callback.onUniversitiesLoaded(universities);


        //mLocalDataStore.loadAllUniversities(callback);

        if(mUniversitiesCache != null && !forceUpdate)
        {
            callback.onUniversitiesLoaded(mUniversitiesCache);
        }else
        {
            getUniversitiesFromRemoteDataStore(callback);
        }
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

    private void getUniversitiesFromRemoteDataStore(DataStore.LoadUniversitiesCallback callback){
        if(mUniversitiesCache == null)
        {
            mUniversitiesCache = new ArrayList<>();
        }
        mRemoteDataStore.loadAllUniversities(new DataStore.LoadUniversitiesCallback() {
            @Override
            public void onUniversitiesLoaded(List<University> universities) {

                refreshCache(universities);
                callback.onUniversitiesLoaded(universities);
            }
        },true);

    }

    private void refreshCache(List<University> universities){
        mUniversitiesCache.clear();

        mUniversitiesCache = universities;
    }
}
