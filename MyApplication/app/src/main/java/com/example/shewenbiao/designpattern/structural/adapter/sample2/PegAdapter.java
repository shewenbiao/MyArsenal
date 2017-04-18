package com.example.shewenbiao.designpattern.structural.adapter.sample2;

/**
 * Created by shewenbiao on 17/4/3.
 */

public class PegAdapter implements IRoundPeg, ISquarePeg{

    private IRoundPeg mRoundPeg;
    private ISquarePeg mSquarePeg;

    public PegAdapter(IRoundPeg roundPeg, ISquarePeg squarePeg) {
        mRoundPeg = roundPeg;
        mSquarePeg = squarePeg;
    }

    @Override
    public void insertIntoHole(String str) {
        mRoundPeg.insertIntoHole(str);
        mSquarePeg.insert(str);
    }

    @Override
    public void insert(String str) {
        mSquarePeg.insert(str);
        mRoundPeg.insertIntoHole(str);
    }
}
