package com.example.shewenbiao.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.shewenbiao.designpattern.creational.builder.CarBuilder;
import com.example.shewenbiao.designpattern.creational.builder.Director;
import com.example.shewenbiao.designpattern.creational.builder.Product;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarBuilder builder = new CarBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();
    }
}
