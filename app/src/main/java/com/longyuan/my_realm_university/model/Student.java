package com.longyuan.my_realm_university.model;

import io.realm.RealmObject;

/**
 * Created by loxu on 07/08/2017.
 */

public class Student extends RealmObject {

    private String id;

    private String age;

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
}
