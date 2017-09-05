package com.longyuan.my_realm_university.student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.model.DisplayItem;
import com.longyuan.my_realm_university.model.Student;
import com.longyuan.my_realm_university.utils.OnItemClickListener;
import com.longyuan.my_realm_university.utils.StudentRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by loxu on 05/09/2017.
 */

public class StudentFragment extends Fragment implements StudentContract.View {

    private StudentContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    private StudentRecyclerViewAdapter mStudentRecyclerViewAdapter;

    public static StudentFragment getInstance(){

        return new StudentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.frag_student,container,false);

        mRecyclerView = (RecyclerView) root.findViewById(R.id.students_list);

        mStudentRecyclerViewAdapter = new StudentRecyclerViewAdapter(new ArrayList<Student>());

        mStudentRecyclerViewAdapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(DisplayItem item) {

                //mPresenter.loadUniversity(item.getId());

            }

            @Override
            public void onItemLongClick(DisplayItem item,int position) {

                //mPresenter.deleteUniversity(item.getId(),position);
            }
        });


        mRecyclerView.setAdapter(mStudentRecyclerViewAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(StudentContract.Presenter presenter) {

        mPresenter = presenter;
    }
}
