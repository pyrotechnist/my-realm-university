package com.longyuan.my_realm_university.University;

import dagger.Module;
import dagger.Provides;

/**
 * Created by loxu on 07/08/2017.
 */


@Module
public class UniversityModule {

    private final UniversityContract.View mView;

    public UniversityModule(UniversityContract.View view) {
        mView = view;
    }

    @Provides
    UniversityContract.View provideUniversityContractView() {
        return mView;
    }

    @Provides
    UniversityContract.Presenter provideUniversityContractPresenter() {
        return new UniversityPresenter(mView);
    }
}
