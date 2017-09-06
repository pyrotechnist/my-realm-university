package com.longyuan.my_realm_university.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.model.Student;

import java.util.List;

/**
 * Created by loxu on 04/09/2017.
 */

public class StudentOnUniversityViewRecyclerViewAdapter extends RecyclerView.Adapter<StudentOnUniversityViewRecyclerViewAdapter.StudentViewHolder> {

    private List<Student> mStudentsList;

    private OnItemClickListener mOnItemClickListener;


    public StudentOnUniversityViewRecyclerViewAdapter(List<Student> students) {
        this.mStudentsList = students;
    }

    @Override
    public StudentOnUniversityViewRecyclerViewAdapter.StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_in_university_item,parent,false);

        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentOnUniversityViewRecyclerViewAdapter.StudentViewHolder holder, int position) {

        final Student student = mStudentsList.get(position);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mOnItemClickListener.onItemClick(student);

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mOnItemClickListener.onItemLongClick(student,position);
                return true;
            }
        });


        holder.mTextViewId.setText(student.getId());

        holder.mTextViewAge.setText(student.getAge());

    }

    @Override
    public int getItemCount() {
        return mStudentsList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView mTextViewId;

        TextView mTextViewAge;

        public StudentViewHolder(View itemView) {
            super(itemView);

            mTextViewId = (TextView) itemView.findViewById(R.id.student_in_university_item_id);

            mTextViewAge = (TextView) itemView.findViewById(R.id.student_in_university_item_age);
        }
    }

    public void replaceData(List<Student> students){

        mStudentsList = students;

        notifyDataSetChanged();
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}
