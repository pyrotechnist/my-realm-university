package com.longyuan.my_realm_university.universitydetails;

import com.longyuan.my_realm_university.model.Student;
import com.longyuan.my_realm_university.model.University;

import java.util.List;

/**
 * Created by loxu on 22/08/2017.
 */

public interface UniversityDetailsContract {


    interface View {

        void showUniversity(University university);

        void updateStudents(List<Student> students);

        void setPresenter(Presenter presenter);

        void refreshUniversitiesDetailsUi(String universityId);
    }

    interface Presenter {

        void start();

        void loadUniversity(String universityId);

        void updateUniversity(String id, String name);

        void deleteStudentFromUniversity(String id, String fk);
    }
}
