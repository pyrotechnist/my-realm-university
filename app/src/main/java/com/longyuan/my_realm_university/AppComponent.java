package com.longyuan.my_realm_university;

import com.longyuan.my_realm_university.University.UniversityPresenter;
import com.longyuan.my_realm_university.data.remote.RemoteDataStore;
import com.longyuan.my_realm_university.network.injection.NetworkModule;
import com.longyuan.my_realm_university.realm.repository.RepositoryModule;
import com.longyuan.my_realm_university.student.StudentPresenter;
import com.longyuan.my_realm_university.universitydetails.UniversityDetailsPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by loxu on 09/08/2017.
 */


@Singleton
@Component(modules = {NetworkModule.class, RepositoryModule.class})
public interface AppComponent {

    void inject(RemoteDataStore remoteDataStore);

    void inject(UniversityPresenter universityPresenter);

    void inject(UniversityDetailsPresenter universityDetailsPresenter);

    void inject(StudentPresenter studentPresenter);

    }
