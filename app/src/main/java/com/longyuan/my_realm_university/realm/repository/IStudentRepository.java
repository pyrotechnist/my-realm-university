package com.longyuan.my_realm_university.realm.repository;

/**
 * Created by loxu on 07/08/2017.
 */

public interface IStudentRepository {


    void loadAllStudents(DataStore.LoadStudentsCallback callback);

    void deleteStudent(String id, DataStore.LoadOrUpdateStudentCallback callback);

    void addStudent(String id, String name, DataStore.LoadOrUpdateStudentCallback callback);

    void updateStudent(String id, String name, DataStore.LoadOrUpdateStudentCallback callback);

    void loadStudent(String id, DataStore.LoadOrUpdateStudentCallback callback);

}
