package com.longyuan.my_realm_university.model;

import io.realm.RealmObject;

/**
 * Created by loxu on 07/08/2017.
 */

public class University extends RealmObject {

    private String id;

    private String name;

    public University(){

    }

    public University(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
