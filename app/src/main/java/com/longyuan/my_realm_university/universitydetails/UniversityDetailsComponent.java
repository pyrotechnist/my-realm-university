package com.longyuan.my_realm_university.universitydetails;

import com.longyuan.my_realm_university.AppComponent;
import com.longyuan.my_realm_university.University.UniversityModule;
import com.longyuan.my_realm_university.utils.FragmentScoped;

import dagger.Component;

/**
 * Created by loxu on 22/08/2017.
 */

@FragmentScoped
@Component(dependencies = AppComponent.class, modules = UniversityDetailsModule.class)
public interface UniversityDetailsComponent {

    void inject(UniversityDetailsActivity activity);
}
