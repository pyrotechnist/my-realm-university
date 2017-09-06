package com.longyuan.my_realm_university.universitydetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.model.DisplayItem;
import com.longyuan.my_realm_university.model.Student;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.utils.OnItemClickListener;
import com.longyuan.my_realm_university.utils.StudentOnUniversityViewRecyclerViewAdapter;
import com.longyuan.my_realm_university.utils.StudentRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loxu on 22/08/2017.
 */

public class UniversityDetailsFragment extends Fragment implements UniversityDetailsContract.View{


    private UniversityDetailsContract.Presenter mPresenter;

    private EditText mTextViewId;

    private EditText mTextViewName;

    private Button mButtonUpdate;

    private Button mButtonCancel;

    private RecyclerView mRecyclerViewStudents;

    private StudentOnUniversityViewRecyclerViewAdapter mStudentRecyclerViewAdapter;

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

        mRecyclerViewStudents = (RecyclerView) root.findViewById(R.id.university_details_students_list);

        mRecyclerViewStudents.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        mStudentRecyclerViewAdapter = new StudentOnUniversityViewRecyclerViewAdapter(new ArrayList<Student>());

        mStudentRecyclerViewAdapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(DisplayItem item) {
                String university = mTextViewName.getText().toString();
                Toast.makeText(getActivity(), "University : "+ university+ " Student: " + item.getId() + " Clicked", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(DisplayItem item, int position) {
                String universityId = mTextViewId.getText().toString();

                mPresenter.deleteStudentFromUniversity(universityId,item.getId());

            }
        });

        mRecyclerViewStudents.setAdapter(mStudentRecyclerViewAdapter);

        mRecyclerViewStudents.setLayoutManager(new LinearLayoutManager(mRecyclerViewStudents.getContext()));

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

        mStudentRecyclerViewAdapter.replaceData(university.getStudents());
    }

    @Override
    public void setPresenter(UniversityDetailsContract.Presenter presenter ) {
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

    @Override
    public void updateStudents(List<Student> students) {
        mStudentRecyclerViewAdapter.replaceData(students);
    }
}
