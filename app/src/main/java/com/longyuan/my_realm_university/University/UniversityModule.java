package com.longyuan.my_realm_university.University;

import dagger.Module;
import dagger.Provides;

/**
 * Created by loxu on 07/08/2017.
 */


@Module
public class UniversityModule {

    private final UniversityContarct.View mView;

    public UniversityModule(UniversityContarct.View view) {
        mView = view;
    }

    @Provides
    UniversityContarct.View provideUniversityContractView() {
        return mView;
    }

    @Provides
    UniversityContarct.Presenter provideUniversityContractPresenter() {
        return new UniversityPresenter(mView);
    }
}
