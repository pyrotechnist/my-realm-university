package com.longyuan.my_realm_university.universitydetails;

import com.longyuan.my_realm_university.model.University;

/**
 * Created by loxu on 22/08/2017.
 */

public interface UniversityDetailsContract {


    interface View {

        void showUniversity(University university);

        void setPresnter(Presenter presnter);
    }

    interface Presenter {

        void start();

        void loadUniversity(String universityId);

        void updateUniversity(String id, String name);
    }
}
