package com.longyuan.my_realm_university.universitydetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.model.University;

/**
 * Created by loxu on 22/08/2017.
 */

public class UniversityDetailsFragment extends Fragment implements UniversityDetailsContract.View{


    private UniversityDetailsContract.Presenter mPresenter;

    private EditText mTextViewId;

    private EditText mTextViewName;

    private Button mButtonUpdate;

    private Button mButtonCancel;

    public static UniversityDetailsFragment getInstance(){

        return new UniversityDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.frag_university_details,container,false);

        mTextViewId = (EditText) root.findViewById(R.id.university_details_id);

        mTextViewName  = (EditText) root.findViewById(R.id.university_details_name);

        mButtonUpdate= (Button) root.findViewById(R.id.university_details_update_button);

        mButtonCancel= (Button) root.findViewById(R.id.university_details_cancel_button);

        mButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.updateUniversity(mTextViewId.getText().toString(),mTextViewName.getText().toString());
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("updated",false);
                getActivity().setResult(Activity.RESULT_OK,returnIntent);
                getActivity().finish();
            }
        });

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
    public void setPresnter(UniversityDetailsContract.Presenter presenter ) {
        mPresenter = presenter ;

    }

    @Override
    public void refreshUniversitiesDetailsUi(String universityId) {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("updated",true);
        returnIntent.putExtra("updated_id",universityId);
        getActivity().setResult(Activity.RESULT_OK,returnIntent);
        getActivity().finish();
    }
}
