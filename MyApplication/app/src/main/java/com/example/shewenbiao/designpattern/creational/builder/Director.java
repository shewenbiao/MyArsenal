package com.example.shewenbiao.designpattern.creational.builder;

/**
 * Created by shewenbiao on 17/3/19.
 */

public class Director {

    private Builder mBuilder;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    //将partA partB partC组装成复杂对象
    //这里是将车轮，方向盘和发动机组装车汽车的过程
    public void construct() {
        mBuilder.buildPartA();
        mBuilder.buildPartB();
        mBuilder.buildPartC();
    }
}
