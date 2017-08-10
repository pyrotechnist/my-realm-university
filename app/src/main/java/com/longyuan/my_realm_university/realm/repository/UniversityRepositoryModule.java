package com.longyuan.my_realm_university.realm.repository;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.constraint.solver.Cache;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.longyuan.my_realm_university.data.local.LocalDataStore;
import com.longyuan.my_realm_university.data.remote.RemoteDataStore;
import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by loxu on 07/08/2017.
 */

@Module
public class UniversityRepositoryModule {

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
