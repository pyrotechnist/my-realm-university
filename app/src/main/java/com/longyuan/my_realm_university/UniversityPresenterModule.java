package com.longyuan.my_realm_university;

import dagger.Module;
import dagger.Provides;

/**
 * Created by loxu on 07/08/2017.
 */

@Module
public class UniversityPresenterModule {

    private final UniversityContarct.View mView;

    public UniversityPresenterModule(UniversityContarct.View view) {
        mView = view;
    }

    @Provides
    UniversityContarct.View provideUniversityContractView() {
        return mView;
    }


}
