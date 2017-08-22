package com.longyuan.my_realm_university.data.remote;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.longyuan.my_realm_university.App;
import com.longyuan.my_realm_university.data.local.LocalDataStore;
import com.longyuan.my_realm_university.model.University;
import com.longyuan.my_realm_university.network.api.UniversityApi;
import com.longyuan.my_realm_university.realm.repository.DataStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by loxu on 09/08/2017.
 */

public class RemoteDataStore implements DataStore{

/*    @Inject
    Retrofit retrofit;*/

    @Inject
    UniversityApi mUniversityApi;

    private LoadUniversitiesCallback mLoadUniversitiesCallback;


    public RemoteDataStore() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void loadAllUniversities(LoadUniversitiesCallback callback) {

        mLoadUniversitiesCallback = callback;

        //.enqueue(retroCallback);
        mUniversityApi.getUniversities()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> callback.onUniversitiesLoaded(data));

    }

    public void deleteUniversity(String id,DeleteUniversityCallback callback){

        mUniversityApi.deleteUniversity(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> callback.onUniversityDeleted(data));
    }


    public void createUniversity(String id,String name,DeleteUniversityCallback callback){

        Map<String, String> queries = new HashMap<>();
        queries.put("id", id);
        queries.put("name", name);

        mUniversityApi.createUniversity(queries)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> callback.onUniversityDeleted(data));
    }

    public void updateUniversity(String id,String name,DeleteUniversityCallback callback){

        Map<String, String> queries = new HashMap<>();
        queries.put("name", name);

        mUniversityApi.updateUniversity(id,queries)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> callback.onUniversityDeleted(data));
    }

    public void loadUniversity(String id,DeleteUniversityCallback callback){

        Map<String, String> queries = new HashMap<>();

        mUniversityApi.updateUniversity(id,queries)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> callback.onUniversityDeleted(data));
    }








    private void createPromotionsAPI() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PromotionAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mPromotionAPI = retrofit.create(PromotionAPI.class);*/


       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PromotionAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        mUniversityApi = retrofit.create(UniversityApi.class);*/
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
