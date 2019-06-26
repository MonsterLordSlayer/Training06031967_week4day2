package com.example.week4day2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Image image;
    RecyclerView rvItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvItem=findViewById(R.id.rvItem);
        RestrofitExample restrofitExample=new RestrofitExample();
        restrofitExample.getService().getPicture("kitten","json","1").enqueue(new Callback<Image>() {
            @Override
            public void onResponse(Call<Image> call, Response<Image> response) {
                Image image=response.body();
                //Log.d("TAG", "onResponse: " + response.toString());
                runonmain(image);
            }

            @Override
            public void onFailure(Call<Image> call, Throwable t) {
                Log.d("TAG","BRUHHH "+t.getMessage());
            }

        });


    }
    private void runonmain(Image image1){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                image=image1;
                Log.d("TAG", "run: "+image.getGenerator());

                RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(rvItem.getContext());
                ItemAdapter adapter=new ItemAdapter(image);
                rvItem.setLayoutManager(layoutManager);
                rvItem.setAdapter(adapter);



            }
        });

    }

}
