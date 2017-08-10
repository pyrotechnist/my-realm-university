package com.longyuan.my_realm_university.University;

import com.longyuan.my_realm_university.AppComponent;
import com.longyuan.my_realm_university.utils.FragmentScoped;

import dagger.Component;

/**
 * Created by loxu on 07/08/2017.
 */

@FragmentScoped
@Component(dependencies = AppComponent.class, modules = UniversityModule.class)
public interface UniversityComponent {

    void inject(UniversityActivity activity);


}
