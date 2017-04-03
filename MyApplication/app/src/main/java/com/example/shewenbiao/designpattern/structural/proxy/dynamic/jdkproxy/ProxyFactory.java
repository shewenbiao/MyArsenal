package com.example.shewenbiao.designpattern.structural.proxy.dynamic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shewenbiao on 17/4/3.
 */

/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */

public class ProxyFactory implements InvocationHandler{

    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //执行目标对象方法
        return method.invoke(target, args);
    }

    /**
     * 给目标对象创建一个代理对象
     * @return
     */
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
}
