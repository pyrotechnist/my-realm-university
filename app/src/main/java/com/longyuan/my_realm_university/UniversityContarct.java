package com.longyuan.my_realm_university;

import com.longyuan.my_realm_university.model.University;

import java.util.List;

/**
 * Created by loxu on 07/08/2017.
 */

public class UniversityContarct {
    interface View{

        void showUniversities(List<University> universities);

        void setPresnter(Presenter presnter);
    }

    interface Presenter{

        void start();

        void loadUniversities();

    }
}
