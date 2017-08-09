package com.longyuan.my_realm_university;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by loxu on 09/08/2017.
 */

@Module
public class AppModule {

    private final Context mContext;

    AppModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}
