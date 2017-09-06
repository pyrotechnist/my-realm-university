package com.longyuan.my_realm_university.realm.repository;

import com.longyuan.my_realm_university.model.Student;
import com.longyuan.my_realm_university.model.StudentFullInfo;
import com.longyuan.my_realm_university.model.University;

import java.util.List;

/**
 * Created by loxu on 08/08/2017.
 */

public interface DataStore {

    interface LoadUniversitiesCallback {

        void onUniversitiesLoaded(List<University> universities);

    }

    interface LoadOrUpdateUniversityCallback {

        void onUniversityLoadedOrUpdated(University university);

    }

    interface LoadStudentsCallback {

        void onStudentsLoaded(List<StudentFullInfo> students);

    }

    interface LoadOrUpdateStudentCallback {

        void onStudentLoadedOrUpdated(StudentFullInfo student);

    }

}
