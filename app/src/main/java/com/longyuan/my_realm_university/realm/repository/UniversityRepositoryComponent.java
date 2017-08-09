package com.longyuan.my_realm_university.realm.repository;

import android.app.Application;
import android.content.Context;

import com.longyuan.my_realm_university.AppModule;
import com.longyuan.my_realm_university.UniversityActivity;
import com.longyuan.my_realm_university.data.remote.RemoteDataStore;
import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by loxu on 07/08/2017.
 */


@Singleton
@Component(modules = {UniversityRepositoryModule.class})
public interface UniversityRepositoryComponent {

    void inject(UniversityActivity activity);
    void inject(RemoteDataStore remoteDataStore);

}
