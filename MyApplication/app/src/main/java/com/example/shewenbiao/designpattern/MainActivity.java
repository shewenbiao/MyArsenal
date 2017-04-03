package com.example.shewenbiao.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.shewenbiao.designpattern.creational.builder.CarBuilder;
import com.example.shewenbiao.designpattern.creational.builder.Director;
import com.example.shewenbiao.designpattern.creational.builder.Product;
import com.example.shewenbiao.designpattern.structural.facade.Computer;
import com.example.shewenbiao.designpattern.structural.facade.ComputerImpl;
import com.example.shewenbiao.designpattern.structural.proxy.dynamic.jdkproxy.ProxyFactory;
import com.example.shewenbiao.designpattern.structural.proxy.staticproxy.IUserDao;
import com.example.shewenbiao.designpattern.structural.proxy.staticproxy.UserDao;
import com.example.shewenbiao.designpattern.structural.proxy.staticproxy.UserDaoProxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Builder
        CarBuilder builder = new CarBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();

        //Facade
        Computer computer = new ComputerImpl();
        computer.start();
        computer.shutDown();

        //Static Proxy
        IUserDao target = new UserDao();//目标对象
        IUserDao proxy = new UserDaoProxy(target);//代理对象,把目标对象传给代理对象,建立代理关系
        proxy.save();//执行的是代理的方法

        //Dynamic Proxy (jdk proxy)
        IUserDao target2 = new UserDao();// 目标对象
        IUserDao proxy2 = (IUserDao) new ProxyFactory(target2).getProxyInstance();//给目标对象，创建代理对象 class $Proxy0   内存中动态生成的代理对象
        proxy2.save();// 执行方法   【代理对象】

        //Dynamic Proxy (cglib proxy)
        com.example.shewenbiao.designpattern.structural.proxy.dynamic.cglibproxy.UserDao target3 =
                new com.example.shewenbiao.designpattern.structural.proxy.dynamic.cglibproxy.UserDao(); //目标对象
        com.example.shewenbiao.designpattern.structural.proxy.dynamic.cglibproxy.UserDao proxy3 =
                (com.example.shewenbiao.designpattern.structural.proxy.dynamic.cglibproxy.UserDao)
                        new com.example.shewenbiao.designpattern.structural.proxy.dynamic.cglibproxy.ProxyFactory(target3).getProxyInstance(); //代理对象
        proxy3.save();//执行代理对象的方法
    }
}
