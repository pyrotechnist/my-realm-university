package com.longyuan.my_realm_university.University;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.utils.OnItemClickListener;
import com.longyuan.my_realm_university.utils.UniversityRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loxu on 07/08/2017.
 */

public class UniversityFragment extends Fragment implements UniversityContarct.View {

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
            public void onItemClick(University item,int position) {

                mPresenter.deleteUniversity(item.getId(),position);
            }

            @Override
            public void onItemLongClick(University item) {

            }
        });


        mRecyclerView.setAdapter(mUniversityRecyclerViewAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));


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
}
