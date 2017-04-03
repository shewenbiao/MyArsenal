package com.example.shewenbiao.designpattern.structural.facade;

/**
 * Created by shewenbiao on 17/4/3.
 */

public class ComputerImpl implements Computer{

    private CPU mCPU;
    private Memory mMemory;
    private Disk mDisk;

    public ComputerImpl() {
        mCPU = new CPU();
        mMemory = new Memory();
        mDisk = new Disk();
    }

    @Override
    public void start() {
        mCPU.start();
        mMemory.start();
        mDisk.start();
    }

    @Override
    public void shutDown() {
        mCPU.shutDown();
        mMemory.shutDown();
        mDisk.shutDown();
    }
}
