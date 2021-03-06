package com.longyuan.my_realm_university.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.model.Student;
import com.longyuan.my_realm_university.model.StudentFullInfo;

import java.util.List;

/**
 * Created by loxu on 04/09/2017.
 */

public class StudentRecyclerViewAdapter extends RecyclerView.Adapter<StudentRecyclerViewAdapter.StudentViewHolder> {

    private List<StudentFullInfo> mStudentsList;

    private OnItemClickListener mOnItemClickListener;


    public StudentRecyclerViewAdapter(List<StudentFullInfo> students) {
        this.mStudentsList = students;
    }

    @Override
    public StudentRecyclerViewAdapter.StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,parent,false);

        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentRecyclerViewAdapter.StudentViewHolder holder, int position) {

        final StudentFullInfo student = mStudentsList.get(position);


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

        if(student.getSchool() != null)
        {
            holder.mTextViewUniversity.setText(student.getSchool().getName());
        }

    }

    @Override
    public int getItemCount() {
        return mStudentsList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView mTextViewId;

        TextView mTextViewAge;

        TextView mTextViewUniversity;

        public StudentViewHolder(View itemView) {
            super(itemView);

            mTextViewId = (TextView) itemView.findViewById(R.id.student_item_id);

            mTextViewAge = (TextView) itemView.findViewById(R.id.student_item_age);

            mTextViewUniversity = (TextView) itemView.findViewById(R.id.student_item_university);
        }
    }

    public void replaceData(List<StudentFullInfo> students){

        mStudentsList = students;

        notifyDataSetChanged();
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}
