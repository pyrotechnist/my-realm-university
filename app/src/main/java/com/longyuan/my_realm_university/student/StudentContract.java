package com.longyuan.my_realm_university.student;

import com.longyuan.my_realm_university.model.Student;
import com.longyuan.my_realm_university.model.StudentFullInfo;

import java.util.List;

/**
 * Created by loxu on 05/09/2017.
 */

public interface StudentContract {

    interface View{

        void setPresenter(Presenter presenter);

        void showStudents(List<StudentFullInfo> students);
    }

    interface  Presenter{

        void start();

        void loadStudents();

    }
}
