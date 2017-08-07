package com.longyuan.my_realm_university;

import android.support.v4.app.Fragment;

import com.longyuan.my_realm_university.model.University;

import java.util.List;

/**
 * Created by loxu on 07/08/2017.
 */

public class UniversityFragment extends Fragment implements UniversityContarct.View {


    public static UniversityFragment getInstance(){

        return new UniversityFragment();
    }


    @Override
    public void showUniversities(List<University> universities) {

    }

    @Override
    public void setPresnter(UniversityContarct.Presenter presnter) {

    }
}
