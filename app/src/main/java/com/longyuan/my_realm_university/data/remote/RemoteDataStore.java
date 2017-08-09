package com.longyuan.my_realm_university.data.remote;

import android.util.Log;

import com.longyuan.my_realm_university.App;
import com.longyuan.my_realm_university.data.local.LocalDataStore;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.realm.repository.DataStore;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by loxu on 09/08/2017.
 */

public class RemoteDataStore implements DataStore{

    @Inject
    Retrofit retrofit;


    private LoadUniversitiesCallback mLoadUniversitiesCallback;


    public RemoteDataStore() {
        App.getUniversityRepositoryComponent().inject(this);
    }

    @Override
    public void loadAllUniversities(LoadUniversitiesCallback callback) {

        mLoadUniversitiesCallback = callback;

        retrofit.create(UniversityApi.class).getUniversities().enqueue(retroCallback);
    }

    private interface UniversityApi {
        @GET("/University")
        Call<List<University>> getUniversities();
    }

    Callback<List<University>> retroCallback = new Callback<List<University>>() {
        @Override
        public void onFailure(Call<List<University>> call, Throwable t) {

        }

        @Override
        public void onResponse(Call<List<University>> call, Response<List<University>> response) {
            if (response.isSuccessful()) {
                List<University> data = new ArrayList<>();
                data.addAll(response.body());
                mLoadUniversitiesCallback.onUniversitiesLoaded(data);
                //recyclerView.setAdapter(new RecyclerViewAdapter(data));
            } else {
                Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }
    };


}
