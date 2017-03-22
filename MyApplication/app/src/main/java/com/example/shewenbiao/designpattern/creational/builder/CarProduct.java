package com.example.shewenbiao.designpattern.creational.builder;

/**
 * Created by shewenbiao on 17/3/19.
 */

public class CarProduct implements Product{

    private CarPart partA;
    private CarPart partB;
    private CarPart partC;

    public CarProduct() {
    }

    public CarPart getPartA() {
        return partA;
    }

    public void setPartA(CarPart partA) {
        this.partA = partA;
    }

    public CarPart getPartB() {
        return partB;
    }

    public void setPartB(CarPart partB) {
        this.partB = partB;
    }

    public CarPart getPartC() {
        return partC;
    }

    public void setPartC(CarPart partC) {
        this.partC = partC;
    }
}
