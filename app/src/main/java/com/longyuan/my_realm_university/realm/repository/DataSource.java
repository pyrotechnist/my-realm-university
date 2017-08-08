package com.longyuan.my_realm_university.realm.repository;

import com.longyuan.my_realm_university.model.University;

import java.util.List;

/**
 * Created by loxu on 08/08/2017.
 */

public interface DataSource {

    interface LoadUniversitiesCallback {

        void onUniversitiesLoaded(List<University> universities);

    }
}
