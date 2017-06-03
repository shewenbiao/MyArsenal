package com.example.shewenbiao.designpattern.creational.prototype;

/**
 * Created by shewenbiao on 17/3/19.
 */

public class AbstractSpoon implements Cloneable {

    private String mSpoonName;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getSpoonName() {
        return mSpoonName;
    }

    public void setSpoonName(String spoonName) {
        mSpoonName = spoonName;
    }
}
