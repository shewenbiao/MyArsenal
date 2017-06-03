package com.example.shewenbiao.designpattern.creational.singleton;

/**
 * Created by shewenbiao on 17/3/21.
 */

public class EagerSingleton {
    //饿汉单例模式
    //在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快

    private static EagerSingleton instance = new EagerSingleton();//静态私有成员，已初始化

    private EagerSingleton() {
        //私有构造函数
    }

    public static EagerSingleton getInstance() { //静态，不用同步（类加载时已初始化，不会有多线程的问题）
        return instance;
    }
}
