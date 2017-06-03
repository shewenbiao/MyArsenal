package com.example.shewenbiao.designpattern.structural.adapter.sample1;

/**
 * Created by shewenbiao on 17/4/3.
 */

public class PegAdapter extends SquarePeg{

    private RoundPeg mRoundPeg;

    public PegAdapter(RoundPeg roundPeg) {
        mRoundPeg = roundPeg;
    }

    @Override
    public void insert(String str) {
        super.insert(str);
        mRoundPeg.insertIntoHole(str);
    }
}
