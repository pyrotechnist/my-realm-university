package com.longyuan.my_realm_university.University.add;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.longyuan.my_realm_university.R;
import com.longyuan.my_realm_university.University.UniversityFragment;

/**
 * Created by LONGYUAN on 2017/8/18.
 */

public class AddUniversityDialogFragment extends DialogFragment {

    private EditText mEditTextId;

    private EditText mEditTextName;

    private Button mButtonPositive;

    private Button mButtonNegative;

    public interface UserNameListener {
        void onFinishUserDialog(String user);
    }

    // Empty constructor required for DialogFragment
    public AddUniversityDialogFragment() {}

   /* @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Dialog")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }*/


    public interface AddUniversityDialogListener {
        public void onDialogPositiveClick(String id, String name,AddUniversityDialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    AddUniversityDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {

                UniversityFragment universityFragment = (UniversityFragment)getFragmentManager().findFragmentById(R.id.frag_content);

                if(universityFragment !=null)
                {
                    mListener = (AddUniversityDialogListener) universityFragment;
                }

            // Instantiate the NoticeDialogListener so we can send events to the host

        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adduniversity_dialog, container);
        mEditTextId = (EditText) view.findViewById(R.id.add_university_id_edittext);

        mEditTextName = (EditText) view.findViewById(R.id.add_university_name_edittext);

        mButtonNegative = (Button) view.findViewById(R.id.add_university_button_negative);

        mButtonPositive = (Button) view.findViewById(R.id.add_university_button_positive);

        mButtonPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDialogPositiveClick(mEditTextId.getText().toString(),mEditTextName.getText().toString(),AddUniversityDialogFragment.this);
            }
        });

        mButtonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDialogNegativeClick(AddUniversityDialogFragment.this);
            }
        });

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Please add university");

    /*    getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Please enter username");*/



        return view;
    }

}
