package com.longyuan.my_realm_university.universitydetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longyuan.my_realm_university.model.University;

/**
 * Created by loxu on 22/08/2017.
 */

public class UniversityDetailsFragment extends Fragment implements UniversityDetailsContract.View{



    public static UniversityDetailsFragment getInstance(){

        return new UniversityDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void showUniversity(University university) {

    }

    @Override
    public void setPresnter(UniversityDetailsContract.Presenter presnter) {

    }
}
