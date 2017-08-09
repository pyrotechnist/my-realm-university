package com.longyuan.my_realm_university;

import com.longyuan.my_realm_university.data.remote.RemoteDataStore;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.UniversityRepositoryModule;
import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by loxu on 09/08/2017.
 */


@Singleton
@Component(modules = {AppModule.class, UniversityRepositoryModule.class})
public interface AppComponent {
    void inject(University activity);
    void inject(RemoteDataStore remoteDataStore);
}
