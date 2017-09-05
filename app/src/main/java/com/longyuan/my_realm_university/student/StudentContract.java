package com.longyuan.my_realm_university.student;

import com.longyuan.my_realm_university.model.Student;

import java.util.List;

/**
 * Created by loxu on 05/09/2017.
 */

public interface StudentContract {

    interface View{

        void setPresenter(Presenter presenter);

        void showStudents(List<Student> students);
    }

    interface  Presenter{

        void start();

        void loadStudents();

    }
}
