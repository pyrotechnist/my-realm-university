package com.longyuan.my_realm_university.realm.repository;

/**
 * Created by loxu on 07/08/2017.
 */

public interface IUniversityRepository {


    void loadAllUniversities(DataStore.LoadUniversitiesCallback callback);

    void deleteUniversity(String id,DataStore.DeleteUniversityCallback callback);

    void addUniversity(String id,String name,DataStore.DeleteUniversityCallback callback);

    void updateUniversity(String id,String name,DataStore.DeleteUniversityCallback callback);

    void loadUniversity(String id,DataStore.DeleteUniversityCallback callback);




}
