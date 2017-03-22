package com.example.shewenbiao.designpattern.creational.factory.abstractfactory;

/**
 * Created by shewenbiao on 17/3/19.
 */

public abstract class Factory {

    public abstract Sample create();

    public abstract Sample2 create(String name);
}
