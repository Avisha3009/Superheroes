package com.example.retroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
TextView txt;
List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        recyclerView=findViewById(R.id.recycler_view);
        txt=findViewById(R.id.textView);
        heroList=new ArrayList<>();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://akabab.github.io/superhero-api/api/ ")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HeroAPI heroapi = retrofit.create(HeroAPI.class);

        Call<List<Hero>> call = heroapi.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

             PutDataIntoRecyclerView(response.body());

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }

    private void PutDataIntoRecyclerView(List<Hero> body) {

        Adaptery adaptery=new Adaptery(this,body);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
    }
}