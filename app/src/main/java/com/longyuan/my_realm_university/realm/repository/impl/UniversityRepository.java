package com.longyuan.my_realm_university.realm.repository.impl;

import android.content.Context;

import com.longyuan.my_realm_university.data.local.LocalDataStore;
import com.longyuan.my_realm_university.data.remote.RemoteDataStore;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.DataStore;
import com.longyuan.my_realm_university.realm.repository.IUniversityRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        universities.addAll(mLocalDataStore.loadAllUniversities());

        callback.onUniversitiesLoaded(universities);

    }
}
