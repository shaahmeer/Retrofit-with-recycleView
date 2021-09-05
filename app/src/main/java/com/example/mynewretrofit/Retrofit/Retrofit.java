package com.example.mynewretrofit.Retrofit;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mynewretrofit.Recycleview.adapter;
import com.example.mynewretrofit.ViewModel.model;
import com.example.mynewretrofit.ViewModel.myapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {


    public  static myapi clientobject;

    RecyclerView recyclerView;
    myapi mapi;
    model data;
    adapter adapter;
    List<model> mydata;
    TextView textView;
    model model;
    String url = "https://jsonplaceholder.typicode.com/";

    public Retrofit() {


        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mapi = retrofit.create(myapi.class);

        Call<List<com.example.mynewretrofit.ViewModel.model>> model = mapi.nmodel();
        model.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<com.example.mynewretrofit.ViewModel.model>> call, Response<List<com.example.mynewretrofit.ViewModel.model>> response) {
                List<model> data = response.body();
                System.out.println(response.body());
                // for (int i = 0; i < data.size(); i++) {
                // textView.append("my title is " + data.get(i).getTitle() );

                //}
                recyclerView.setAdapter(new adapter(data));
            }

            @Override
            public void onFailure(Call<List<com.example.mynewretrofit.ViewModel.model>> call, Throwable t) {

            }


        });
    }

}



