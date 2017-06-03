package com.example.shewenbiao.designpattern.creational.builder;

/**
 * Created by shewenbiao on 17/3/19.
 */

public interface Builder {

    //创建部件A 比如创建汽车车轮
    void buildPartA();

    //创建部件B 比如创建汽车方向盘
    void buildPartB();

    //创建部件C 比如创建汽车发动机
    void buildPartC();

    //最后返回组装成品结果（返回最后装配好的汽车）
    //成品的组装过程不在这里进行，而是在Director类中进行
    //从而实现解耦过程和部件
    Product getResult();
}
