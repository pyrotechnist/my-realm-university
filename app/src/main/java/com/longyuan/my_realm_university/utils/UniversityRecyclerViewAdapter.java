package com.longyuan.my_realm_university.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.model.University;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by loxu on 08/08/2017.
 */

public class UniversityRecyclerViewAdapter extends RecyclerView.Adapter<UniversityRecyclerViewAdapter.UniversityViewHolder> {

    private List<University> mUniversities;

    private OnItemClickListener mOnItemClickListener;

    public UniversityRecyclerViewAdapter(List<University> universities) {
        mUniversities = universities;
    }

    @Override
    public UniversityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.university_item,parent,false);

        return  new UniversityViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(UniversityViewHolder holder, int position) {

        final University university = mUniversities.get(position);

        holder.mTextViewId.setText(university.getId());

        holder.mTextViewName.setText(university.getName());

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                mOnItemClickListener.onItemClick(university);
            }
        };


        View.OnLongClickListener longListner = new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                mOnItemClickListener.onItemLongClick(university,position);
                return true;
            }
        };

        holder.itemView.setOnClickListener(listener);
        holder.itemView.setOnLongClickListener(longListner);


    }


    @Override
    public int getItemCount() {
        return mUniversities.size();
    }

    public void replaceData(List<University> universities){

        mUniversities = universities;

        notifyDataSetChanged();
    }

    public void deleteUniversity(int position){
        mUniversities.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mUniversities.size());
    }


    public void AddUniversity(University university){
        mUniversities.add(university);
        replaceData(mUniversities);
    }


    public static class UniversityViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewId;

        TextView mTextViewName;

        public UniversityViewHolder(View itemView) {
            super(itemView);

            mTextViewId = (TextView) itemView.findViewById(R.id.university_item_id);

            mTextViewName = (TextView) itemView.findViewById(R.id.university_item_name);
        }
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}

