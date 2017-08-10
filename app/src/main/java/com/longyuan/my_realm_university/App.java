package com.longyuan.my_realm_university;

import android.app.Application;

import com.longyuan.my_realm_university.network.injection.NetworkModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by loxu on 07/08/2017.
 */

public class App extends Application{


        private static AppComponent mAppComponent;

        @Override
        public void onCreate() {
            super.onCreate();

            Realm.init(this);
            RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
            Realm.setDefaultConfiguration(realmConfig);

            mAppComponent = DaggerAppComponent.builder()
                    .networkModule(new NetworkModule("http://10.0.2.2:1337"))
                    .build();

        }

        public static AppComponent getAppComponent() {

            return  mAppComponent;
        }




}
