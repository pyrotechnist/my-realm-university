package com.longyuan.my_realm_university.student;

import com.longyuan.my_realm_university.AppComponent;
import com.longyuan.my_realm_university.utils.FragmentScoped;

import dagger.Component;

/**
 * Created by loxu on 05/09/2017.
 */

@FragmentScoped
@Component(dependencies = AppComponent.class, modules = StudentModule.class)
public interface StudentComponent {

    void inject(StudentActivity activity);
}
