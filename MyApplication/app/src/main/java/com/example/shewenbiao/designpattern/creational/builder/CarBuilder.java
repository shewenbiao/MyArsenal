package com.example.shewenbiao.designpattern.creational.builder;

/**
 * Created by shewenbiao on 17/3/19.
 */

public class CarBuilder implements Builder {

    private CarPart partA;
    private CarPart partB;
    private CarPart partC;

    @Override
    public void buildPartA() {
        //这里是具体如何构建partA的代码
    }

    @Override
    public void buildPartB() {
        //这里是具体如何构建partBr的代码
    }

    @Override
    public void buildPartC() {
        //这里是具体如何构建partC的代码
    }

    @Override
    public Product getResult() {
        CarProduct product = new CarProduct();
        product.setPartA(partA);
        product.setPartB(partB);
        product.setPartC(partC);
        return product;
    }
}
