package com.example.mynewretrofit.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mynewretrofit.R;
import com.example.mynewretrofit.Recycleview.adapter;

import com.example.mynewretrofit.ViewModel.model;
import com.example.mynewretrofit.ViewModel.myapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String url = "https://api.coindesk.com/v1/bpi/currentprice.json";

    public static myapi clientobject;

    RecyclerView recyclerView;
    myapi mapi;
    model data;
    adapter adapter;
    List<model> mydata;
    TextView textView;
    model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.t1);


        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(new adapter(mydata));

          retrofit();


    }



    public void retrofit() {
        String url = "https://jsonplaceholder.typicode.com/";


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








