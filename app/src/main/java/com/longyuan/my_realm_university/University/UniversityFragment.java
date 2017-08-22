package com.longyuan.my_realm_university.University;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.University.add.AddUniversityDialogFragment;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.universitydetails.UniversityDetailsActivity;
import com.longyuan.my_realm_university.utils.OnItemClickListener;
import com.longyuan.my_realm_university.utils.UniversityRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loxu on 07/08/2017.
 */

public class UniversityFragment extends Fragment implements UniversityContarct.View,AddUniversityDialogFragment.AddUniversityDialogListener {

    private UniversityContarct.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    private UniversityRecyclerViewAdapter mUniversityRecyclerViewAdapter;

    public static UniversityFragment getInstance(){

        return new UniversityFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.frag_main,container,false);

        mRecyclerView = (RecyclerView) root.findViewById(R.id.universities_list);

        mUniversityRecyclerViewAdapter = new UniversityRecyclerViewAdapter(new ArrayList<University>());

        mUniversityRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(University item) {

                mPresenter.loadUniversity(item.getId());

                //mPresenter.deleteUniversity(item.getId());
            }

            @Override
            public void onItemLongClick(University item,int position) {

                mPresenter.deleteUniversity(item.getId(),position);
            }
        });


        mRecyclerView.setAdapter(mUniversityRecyclerViewAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));


        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                AddUniversityDialogFragment addUniversityDialogFragment = new AddUniversityDialogFragment();

                addUniversityDialogFragment.show(fragmentManager,"addUniversityDialogFragment");
            }
        });

        return root;
    }

    @Override
    public void showUniversities(List<University> universities) {

        mUniversityRecyclerViewAdapter.replaceData(universities);
    }

    @Override
    public void setPresnter(UniversityContarct.Presenter presnter) {

        mPresenter = presnter;

    }

    @Override
    public void deleteUniversityOnRecyclerView(int postion){

        mUniversityRecyclerViewAdapter.deleteUniversity(postion);
    }

    @Override
    public void addUniversityOnRecyclerView(University university){

        mUniversityRecyclerViewAdapter.AddUniversity(university);
    }

    @Override
    public void onDialogPositiveClick(String id, String name, AddUniversityDialogFragment dialog) {

        dialog.dismiss();

        mPresenter.addUniversity(id,name);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
    }

    @Override
    public void showUniversityDetailsUi(String universityId) {
        Intent intent = new Intent(getContext(), UniversityDetailsActivity.class);
        intent.putExtra(UniversityDetailsActivity.EXTRA_UNIVERSITY_ID, universityId);
        startActivity(intent);
    }
}
