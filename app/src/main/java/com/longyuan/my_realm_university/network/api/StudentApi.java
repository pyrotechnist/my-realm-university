package com.longyuan.my_realm_university.network.api;

import com.longyuan.my_realm_university.model.Student;

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
    Observable<List<Student>> getStudents();

    @GET("/student/{id}")
    Observable<Student> loadStudent(@Path("id") String id);

    @GET("/student/destroy/{id}")
    Observable<Student> deleteStudent(@Path("id") String id);

    @GET("/student/create")
    Observable<Student> createStudent(@QueryMap Map<String, String> options);

    @GET("/student/update/{id}")
    Observable<Student> updateStudent(@Path("id") String id,@QueryMap Map<String, String> options);

}
