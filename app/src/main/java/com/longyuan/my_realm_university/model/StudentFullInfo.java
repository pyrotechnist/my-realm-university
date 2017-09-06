package com.longyuan.my_realm_university.model;

import io.realm.RealmObject;

/**
 * Created by loxu on 07/08/2017.
 */

public class StudentFullInfo extends RealmObject implements DisplayItem {

    private String id;

    private String age;

    private University school;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public University getSchool() {
        return school;
    }

    public void setSchool(University school) {
        this.school = school;
    }
}
