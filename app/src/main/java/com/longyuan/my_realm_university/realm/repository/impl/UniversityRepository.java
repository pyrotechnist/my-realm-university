package com.longyuan.my_realm_university.realm.repository.impl;

import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.DataSource;
import com.longyuan.my_realm_university.realm.repository.IUniversityRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by loxu on 07/08/2017.
 */
@Singleton
public class UniversityRepository implements IUniversityRepository {

    private final static Map<String, University> UNIVERSITY_SERVICE_DATA;

    static {
        UNIVERSITY_SERVICE_DATA = new LinkedHashMap<>(2);
        addUniversity("1", "YYYY");
        addUniversity("2", "HHHHH");
    }

    private static void addUniversity(String id, String name) {
        University newUniversity = new University(id, name);
        UNIVERSITY_SERVICE_DATA.put(newUniversity.getId(), newUniversity);
    }


    @Inject
    UniversityRepository(){
    }




    @Override
    public void loadAllUniversities(DataSource.LoadUniversitiesCallback callback) {

        callback.onUniversitiesLoaded(new ArrayList<University>(UNIVERSITY_SERVICE_DATA.values()));

    }
}
