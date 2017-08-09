package com.longyuan.my_realm_university.data.local;

import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.DataStore;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by loxu on 09/08/2017.
 */

public class LocalDataStore implements DataStore{

    private final static Map<String, University> UNIVERSITY_SERVICE_DATA;

    static {
        UNIVERSITY_SERVICE_DATA = new LinkedHashMap<>();
        addUniversity("1", "YYYY");
        addUniversity("2", "HHHHH");
        addUniversity("3", "CCCCCC");
    }

    private static void addUniversity(String id, String name) {
        University newUniversity = new University(id, name);
        UNIVERSITY_SERVICE_DATA.put(newUniversity.getId(), newUniversity);
    }


    @Inject
    public LocalDataStore(){

    }




    @Override
    public void loadAllUniversities(DataStore.LoadUniversitiesCallback callback) {

        callback.onUniversitiesLoaded(new ArrayList<University>(UNIVERSITY_SERVICE_DATA.values()));

    }


    public List<University> loadAllUniversities() {

        return new ArrayList<University>(UNIVERSITY_SERVICE_DATA.values());

    }
}
