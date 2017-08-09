package com.longyuan.my_realm_university;

import android.app.Application;

import com.longyuan.my_realm_university.realm.repository.DaggerUniversityRepositoryComponent;
import com.longyuan.my_realm_university.realm.repository.UniversityRepositoryComponent;
import com.longyuan.my_realm_university.realm.repository.UniversityRepositoryModule;
import com.longyuan.my_realm_university.realm.repository.impl.UniversityRepository;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by loxu on 07/08/2017.
 */

public class App extends Application{


        private static UniversityRepositoryComponent mUniversityRepositoryComponent;

        @Override
        public void onCreate() {
            super.onCreate();

            //RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
            //Realm.setDefaultConfiguration(realmConfig);

            mUniversityRepositoryComponent = DaggerUniversityRepositoryComponent.builder()
                    .universityRepositoryModule(new UniversityRepositoryModule("http://localhost:1337"))
                    .build();

        }

        public static UniversityRepositoryComponent getUniversityRepositoryComponent() {

            return  mUniversityRepositoryComponent;
        }




}
