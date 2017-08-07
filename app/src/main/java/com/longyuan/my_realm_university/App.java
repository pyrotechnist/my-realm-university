package com.longyuan.my_realm_university;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by loxu on 07/08/2017.
 */

public class App extends Application{


        //private Uni

        @Override
        public void onCreate() {
            super.onCreate();

            RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
            Realm.setDefaultConfiguration(realmConfig);

        }

}
