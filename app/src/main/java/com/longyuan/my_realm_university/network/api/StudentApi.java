package com.longyuan.my_realm_university.network.api;

import com.longyuan.my_realm_university.model.Student;
import com.longyuan.my_realm_university.model.StudentFullInfo;

import java.util.List;
import java.util.Map;

import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by loxu on 05/09/2017.
 */

public interface StudentApi {

    @GET("/student")
    Observable<List<StudentFullInfo>> getStudents();

    @GET("/student/{id}")
    Observable<StudentFullInfo> loadStudent(@Path("id") String id);

    @GET("/student/destroy/{id}")
    Observable<StudentFullInfo> deleteStudent(@Path("id") String id);

    @GET("/student/create")
    Observable<StudentFullInfo> createStudent(@QueryMap Map<String, String> options);

    @GET("/student/update/{id}")
    Observable<StudentFullInfo> updateStudent(@Path("id") String id,@QueryMap Map<String, String> options);

}
