package com.longyuan.my_realm_university.student;

import dagger.Module;
import dagger.Provides;

/**
 * Created by loxu on 05/09/2017.
 */

@Module
public class StudentModule {

    private final StudentContract.View mView;

    public StudentModule(StudentContract.View view) {
        this.mView = view;
    }

    @Provides
    StudentContract.View provideStudentContractView() {
        return mView;
    }

    @Provides
    StudentContract.Presenter provideStudentContractPresenter() {
        return new StudentPresenter(mView);
    }
}
