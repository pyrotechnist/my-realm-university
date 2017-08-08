package com.longyuan.my_realm_university.realm.repository;

import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by loxu on 07/08/2017.
 */


@Singleton
@Component()
public interface UniversityRepositoryComponent {

    UniversityRepository getUniversityRepository();
}
