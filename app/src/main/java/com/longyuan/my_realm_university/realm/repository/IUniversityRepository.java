package com.longyuan.my_realm_university.realm.repository;

/**
 * Created by loxu on 07/08/2017.
 */

public interface IUniversityRepository {


    void loadAllUniversities(DataStore.LoadUniversitiesCallback callback);

    void deleteUniversity(String id,DataStore.LoadOrUpdateUniversityCallback callback);

    void createUniversity(String id,String name,DataStore.LoadOrUpdateUniversityCallback callback);

    void updateUniversity(String id,String name,DataStore.LoadOrUpdateUniversityCallback callback);

    void loadUniversity(String id,DataStore.LoadOrUpdateUniversityCallback callback);

    void addStudentToUniversity(String id,String fk,DataStore.LoadOrUpdateUniversityCallback callback);

    void deleteStudentFromUniversity(String id,String fk,DataStore.LoadOrUpdateUniversityCallback callback);
}
