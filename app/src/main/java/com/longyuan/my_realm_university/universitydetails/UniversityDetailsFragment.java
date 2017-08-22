package com.longyuan.my_realm_university.universitydetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.model.University;

/**
 * Created by loxu on 22/08/2017.
 */

public class UniversityDetailsFragment extends Fragment implements UniversityDetailsContract.View{


    private UniversityDetailsContract.Presenter mPresenter;

    private TextView mTextViewId;

    private TextView mTextViewName;

    public static UniversityDetailsFragment getInstance(){

        return new UniversityDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.frag_university_details,container,false);

        mTextViewId = (TextView) root.findViewById(R.id.university_details_id);

        mTextViewName  = (TextView) root.findViewById(R.id.university_details_name);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();

    }

    @Override
    public void showUniversity(University university) {
        mTextViewId.setText(university.getId());

        mTextViewName.setText(university.getName());
    }

    @Override
    public void setPresnter(UniversityDetailsContract.Presenter presnter) {
        mPresenter = presnter;

    }
}
