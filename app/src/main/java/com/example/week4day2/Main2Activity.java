package com.example.week4day2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {
    ImageView ivShowimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ivShowimage=findViewById(R.id.ivShowimage);
        Intent intent = getIntent();
        String url=intent.getStringExtra("image");
        Glide.with(ivShowimage).load(url).into(ivShowimage);
    }
}
