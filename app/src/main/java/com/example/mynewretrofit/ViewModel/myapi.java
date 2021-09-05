package com.example.mynewretrofit.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface myapi {

    @GET("posts")
    Call<List<model>> nmodel();
}
