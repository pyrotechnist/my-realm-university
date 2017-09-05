package com.longyuan.my_realm_university.realm.repository;

import com.longyuan.my_realm_university.data.local.LocalDataStore;
import com.longyuan.my_realm_university.data.remote.RemoteDataStore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by loxu on 07/08/2017.
 */

@Module
public class StudentRepositoryModule {

    @Provides
    @Singleton
    RemoteDataStore providesRemoteDataStore() {
        return new RemoteDataStore();
    }

    @Provides
    @Singleton
    LocalDataStore providesLocalDataStore() {
        return new LocalDataStore();
    }

/*    @Provides
    @Singleton
    public UniversityRepository provideUniversityRepository(final RemoteDataStore remoteDataStore, final LocalDataStore localDataStore) {
        return new UniversityRepository(remoteDataStore, localDataStore);
    }*/


}
