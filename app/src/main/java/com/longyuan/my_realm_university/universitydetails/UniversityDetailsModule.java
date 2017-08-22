package com.longyuan.my_realm_university.universitydetails;

import dagger.Module;
import dagger.Provides;

/**
 * Created by loxu on 22/08/2017.
 */
@Module
public class UniversityDetailsModule {

    private final UniversityDetailsContract.View mView;

    private String mUniversityId;

    public UniversityDetailsModule(UniversityDetailsContract.View view, String universityId) {
        mView = view;
        mUniversityId = universityId;
    }

    @Provides
    UniversityDetailsContract.View provideUniversityContractView() {
        return mView;
    }

    @Provides
    UniversityDetailsContract.Presenter provideUniversityContractPresenter() {
        return new UniversityDetailsPresenter(mView);
    }
}
