package com.example.shewenbiao.designpattern.creational.factory.abstractfactory;

/**
 * Created by shewenbiao on 17/3/19.
 */

public class SimpleFactory extends Factory {

    @Override
    public Sample create() {
        return new SampleA();
    }

    @Override
    public Sample2 create(String name) {
        return new Sample2A();
    }
}
