package com.longyuan.my_realm_university.network.api;

import com.longyuan.my_realm_university.model.University;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by loxu on 10/08/2017.
 */

public interface UniversityApi {

        @GET("/University")
        Observable<List<University>> getUniversities();

}
