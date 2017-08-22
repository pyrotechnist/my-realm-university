package com.longyuan.my_realm_university.University;

import com.longyuan.my_realm_university.model.University;

import java.util.List;

/**
 * Created by loxu on 07/08/2017.
 */

public interface UniversityContarct {
    interface View{

        void showUniversities(List<University> universities);

        void setPresnter(Presenter presnter);

        void deleteUniversityOnRecyclerView(int postion);

        void addUniversityOnRecyclerView(University university);

        void showUniversityDetailsUi(String universityId);
    }

    interface Presenter{

        void start();

        void loadUniversities();

        void deleteUniversity(String id,int position);

        void addUniversity(String id,String name);

        void loadUniversity(String universityId);
    }
}
