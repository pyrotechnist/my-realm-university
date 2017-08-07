package com.longyuan.my_realm_university;

import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import dagger.Component;

/**
 * Created by loxu on 07/08/2017.
 */


@Component(dependencies = UniversityRepository.class, modules = UniversityPresenterModule.class)
public interface UniversityComponent {

    void inject(UniversityActivity activity);

}
