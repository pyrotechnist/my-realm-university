package com.longyuan.my_realm_university.realm.repository.impl;

import com.longyuan.my_realm_university.data.local.LocalDataStore;
import com.longyuan.my_realm_university.data.remote.RemoteDataStore;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.DataStore;
import com.longyuan.my_realm_university.realm.repository.IStudentRepository;
import com.longyuan.my_realm_university.realm.repository.IUniversityRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by loxu on 07/08/2017.
 */

public class StudentRepository implements IStudentRepository {

    private LocalDataStore mLocalDataStore;
    private RemoteDataStore mRemoteDataStore;


    @Inject
    public StudentRepository(RemoteDataStore remoteDataStore, LocalDataStore localDataStore) {
        this.mLocalDataStore = localDataStore;
        this.mRemoteDataStore = remoteDataStore;
    }


    @Override
    public void loadAllStudents(DataStore.LoadStudentsCallback callback) {

        mRemoteDataStore.loadAllStudents(callback);
    }

    @Override
    public void deleteStudent(String id, DataStore.LoadOrUpdateStudentCallback callback) {

    }

    @Override
    public void addStudent(String id, String name, DataStore.LoadOrUpdateStudentCallback callback) {

    }

    @Override
    public void updateStudent(String id, String name, DataStore.LoadOrUpdateStudentCallback callback) {

    }

    @Override
    public void loadStudent(String id, DataStore.LoadOrUpdateStudentCallback callback) {

    }
}
