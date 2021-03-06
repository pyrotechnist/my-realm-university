package com.longyuan.my_realm_university.network.api;

import com.longyuan.my_realm_university.model.University;

import java.util.List;
import java.util.Map;


import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by loxu on 10/08/2017.
 */

public interface UniversityApi {

        @GET("/University")
        Observable<List<University>> getUniversities();

        @GET("/University/{id}")
        Observable<University> loadUniversity(@Path("id") String id);

        @GET("/University/destroy/{id}")
        Observable<University> deleteUniversity(@Path("id") String id);

        @GET("/University/create")
        Observable<University> createUniversity(@QueryMap Map<String, String> options);

        @GET("/University/update/{id}")
        Observable<University> updateUniversity(@Path("id") String id,@QueryMap Map<String, String> options);

        @POST("/University/{id}/Students/{fk}")
        Observable<University> addStudentToUniversity(@Path("id") String id,@Path("fk") String fk);

        @DELETE("/University/{id}/Students/{fk}")
        Observable<University> deleteStudentFromUniversity(@Path("id") String id,@Path("fk") String fk);

}
