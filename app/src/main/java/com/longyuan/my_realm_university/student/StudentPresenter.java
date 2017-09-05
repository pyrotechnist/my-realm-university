package com.longyuan.my_realm_university.student;

import com.longyuan.my_realm_university.App;
import com.longyuan.my_realm_university.realm.repository.impl.StudentRepository;

import javax.inject.Inject;

/**
 * Created by loxu on 05/09/2017.
 */

public class StudentPresenter implements StudentContract.Presenter {

    private StudentContract.View mView;

    @Inject
    StudentRepository mStudentRepository;

    public StudentPresenter(StudentContract.View view) {

        this.mView = view;

        App.getAppComponent().inject(this);

        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
