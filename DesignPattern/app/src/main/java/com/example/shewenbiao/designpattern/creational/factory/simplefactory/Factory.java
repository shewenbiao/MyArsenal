package com.example.shewenbiao.designpattern.creational.factory.simplefactory;

/**
 * Created by shewenbiao on 17/3/19.
 */

public class Factory {

    public static Sample create(int which) {
        switch (which) {
            case 1:
                return new SampleA();
            case 2:
                return new SampleB();
            default:
                return null;
        }
    }
}
